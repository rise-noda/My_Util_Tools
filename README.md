# My_Util_Tools

AWS（S3, CloudFront, Lambda）を基盤とした、Webエンジニア向けのユーティリティツールプラットフォームです。

## 概要
日常的な開発業務をサポートするツール群を提供します。現在は「コード変換機能」を中心に構築しており、今後、様々なエンジニア向けツールを順次追加していく拡張可能な設計を採用しています。

## ツール構成
- **コード変換ツール**: エンコード・デコード変換を行う (Base64(テキストベース)・URL・HTML)

## 技術スタック
- **Frontend**: Vue.js (Vite)
- **Backend**: AWS Lambda (Java / Maven)
- **Infra**: 
  - **Amazon S3**: 静的ホスティング
  - **Amazon CloudFront**: CDN（OACによるセキュアな配信）
  - **Route 53**: 独自ドメイン管理
  - **AWS Certificate Manager (ACM)**: SSL/TLS証明書管理

## インフラ構成図
<img width="608" height="360" alt="image" src="https://github.com/user-attachments/assets/08363aaf-d313-4535-994c-89b942dc0f82" />
