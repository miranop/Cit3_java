<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import="poker.PokerModel" %>
<%
PokerModel model = (PokerModel)request.getAttribute("model");
String label = model.getButtonLabel();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Poker</title>
    <style>
        h1 {
            text-align: center;
            background-color: silver;
            color: blue;
            margin: 10px;
        }
        .num {
            text-align: center;
        }
        .chip {
            text-align: center;
        }
        .message {
            text-align: center;
        }
        .table {
            margin: 0 auto;
            
        }
        .td {
            padding: 10px;
            text-align: center;
        }
        .img {
            display: block;
            margin: 0 auto;
            width: 100px;
            height: 150px;
            cursor: pointer;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .item {
            margin-top: 10px; /* ラジオボックスと画像の間の余白を設定 */
        }
        .item label {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>ポーカーゲーム</h1>
    <hr>
    <div class="num">ゲーム回数：<%= model.getGames() %></div>
    <br>
    <div class="chip">チップ：<%= model.getChips() %></div>
    <hr>
    <div class="message"><%= model.getMessage() %></div>
    <form action="/s2232088/PokerServlet" method="POST">
        <table class="table">
            <tr class="container">
                <td class="item">
                    <label for="change0"><img src="cards/<%= model.getHandcardAt(0) %>.png"></label>
                    <input type="checkbox" id="change0" name="change" value="0">
                </td>
                <td class="item">
                    <label for="change1"><img src="cards/<%= model.getHandcardAt(1) %>.png"></label>
                    <input type="checkbox" id="change1" name="change" value="1">
                </td>
                <td class="item">
                    <label for="change2"><img src="cards/<%= model.getHandcardAt(2) %>.png"></label>
                    <input type="checkbox" id="change2" name="change" value="2">
                </td>
                <td class="item">
                    <label for="change3"><img src="cards/<%= model.getHandcardAt(3) %>.png"></label>
                    <input type="checkbox" id="change3" name="change" value="3">
                </td>
                <td class="item">
                    <label for="change4"><img src="cards/<%= model.getHandcardAt(4) %>.png"></label>
                    <input type="checkbox" id="change4" name="change" value="4">
                </td>
            </tr>
        </table>
        <input type="submit" value="<%= label %>">
    </form>
    <hr>
    <a href="/s2232088/PokerServlet">リセット</a>
</body>
</html>
