var stompClient = Stomp.over(new SockJS('/ws')); // WebSocket 서버에 연결

stompClient.connect({}, function (frame) {
    stompClient.subscribe('/topic/cafe', function (message) { // 웹소켓 구독
        showMessage(JSON.parse(message.body)); // 메시지 표시
    });
});

function showMessage(message) {
    var messageList = document.getElementById("messageList");
    var li = document.createElement("li");
    li.textContent = message;
    messageList.appendChild(li);
}
