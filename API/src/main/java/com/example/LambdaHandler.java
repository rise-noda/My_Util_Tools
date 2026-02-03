package com.example;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.logic.Transformer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final Transformer transformer = new Transformer();
	
	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		
		// CORSの設定（これがないとVueから呼ぶときにブラウザでエラーになります）
        response.setHeaders(Map.of(
            "Access-Control-Allow-Origin", "*",
            "Access-Control-Allow-Methods", "POST,OPTIONS"
        ));

        try {
            // 1. Vueから送られてきたボディ（JSON）を解析
            JsonNode body = objectMapper.readTree(input.getBody());
            String text = body.get("input").asText();
            String type = body.get("type").asText();
            String mode = body.get("mode").asText();

            // 2. 変換ロジック呼び出し
            String result = transformer.transform(text, type, mode);

            // 3. レスポンス作成
            response.setStatusCode(200);
            response.setBody(result);

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setBody("Error: " + e.getMessage());
        }

        return response;
    }
}
