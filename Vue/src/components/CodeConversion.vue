<script setup>
import { ref } from 'vue'

const mode = ref('encode') // エンコード or デコード 状態チェック
const type = ref('base64')
const inputText = ref('')  // 入力値
const resultText = ref('') // 実行結果
const my_tool_api_url = 'https://xl5wcsiu8l.execute-api.ap-northeast-1.amazonaws.com/default/my_tool_api'

// 実行ボタンを押した時の処理
const execution = async () => {
    if(!inputText.value){
        alert('文字を入力してください')
        return
    }

    const payload = {
        mode: mode.value,
        type: type.value,
        input: inputText.value
    }

    // エンコード・デコードAPI呼び出し
    const response = await fetch(my_tool_api_url, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            mode: mode.value,
            type: type.value,
            input: inputText.value
        })
    })
    const data = await response.text()
    resultText.value = data
}

const copyClipboard = () => {
  if (!resultText.value) return
  navigator.clipboard.writeText(resultText.value)
}

</script>

<template> 
    <div class="container">
        <div class="settings-bar">
            <div class="setting-item">
                <select v-model="type" class="select-box">
                    <option value="base64">base64</option>
                    <option value="url">URL</option>
                    <option value="html">HTML</option>
                </select>
            </div>
            
            <div class="setting-item radio-group">
                <label><input type="radio" v-model="mode" value="encode">エンコード</label>
                <label><input type="radio" v-model="mode" value="decode">デコード</label>
            </div> 

            <div class="setting-item">
                <button class="copy-btn" :disabled="!resultText" @click="copyClipboard">
                    結果をコピー
                </button>
            </div>

            <button class="exec-btn" @click="execution">実行</button>
        </div>

        <div class="editor-main">
            <div class="editor-box">
                <textarea v-model="inputText" placeholder="ここに文字列を入力してください"></textarea>
            </div>
            <div class="editor-box">
                <textarea v-model="resultText" readonly placeholder="結果がここに表示されます"></textarea>
            </div>
        </div>
    </div>
</template>

<style scoped>
.container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

/* 上部バーのレイアウト */
.settings-bar {
  display: flex;
  align-items: center;
  gap: 15px;
  background-color: #fff;
  padding: 10px;
  border-radius: 4px;
}

.setting-item {
  background: white;
  padding: 5px 10px;
}

.select-box {
    padding: 6px;
    font-size: 15px;
}

.radio-group {
    border: 1px solid #333;
    font-size: 14px;
    padding-right: 20px;
}

/* 実行ボタンのスタイル */
.exec-btn {
  margin-left: auto; /* 右端に寄せる */
  padding: 8px 20px;
  background-color: lightgreen;
  border: 1px solid #333333;
  cursor: pointer;
  font-weight: bold;
}

/* メインエリアを左右に広げる */
.editor-main {
  display: flex;
  gap: 20px;
  flex: 1; /* 親の余った高さを全部使う */
  min-height: 500px;
}

.editor-box {
  flex: 1; /* 左右均等 */
  display: flex;
  flex-direction: column;
}

.label {
  padding: 5px 10px;
  background: #eee;
  border: 1px solid #333;
  border-bottom: none;
  width: fit-content;
}

textarea {
  flex: 1; /* 枠いっぱいに広げる */
  width: 100%;
  padding: 15px 4px;
  border: 1px solid #333;
  resize: none; /* 手動サイズ変更を無効化 */
  font-family: monospace;
  background-color: #e9e9e9; /* 画像のイメージに合わせた背景色 */
}

/* コピーボタンの無効化スタイル */
button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}
</style>
