<html>
<body>
<h2>Hello World!</h2>
<form action="/bank-solution" method="post">
    <input type="hidden" name="command" value="login">
    <input type="text" name="login" placeholder="Enter login">
    <input type="password" name="password" placeholder="Enter password">
    <button type="submit">send</button>
</form>
<a href="/bank-solution?command=showRegistration">registration</a>
<a href="/bank-solution?command=showFillUserData">FillUserData</a>
</body>
</html>
