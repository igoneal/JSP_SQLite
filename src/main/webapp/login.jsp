<%-- 
    Document   : login
    Created on : 18 Jan 2025, 12:30:19
    Author     : Godwin Idoje
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Champions School Platform</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
                * {
                    box-sizing: border-box;
                }
                .row::after {
                content: "";
                clear: both;
                display: table;
                }
                [class*="col-"] {
                    float: left;
                    padding: 15px;
                }
                .col-1 {width: 8.33%;}
                .col-2 {width: 16.66%;}
                .col-3 {width: 25%;}
                .col-4 {width: 33.33%;}
                .col-5 {width: 41.66%;}
                .col-6 {width: 50%;}
                .col-7 {width: 58.33%;}
                .col-8 {width: 66.66%;}
                .col-9 {width: 75%;}
                .col-10 {width: 83.33%;}
                .col-11 {width: 91.66%;}
                .col-12 {width: 100%;}
            html {
                font-family: "Lucida Sans", sans-serif;
                }
                .header {
                        background-color: #9933cc;
                        color: #ffffff;
                        padding: 15px;
                }
                .menu ul {
                 list-style-type: none;
                 margin: 0;
                 padding: 0;
                }
                .menu li {
                padding: 8px;
                margin-bottom: 7px;
                background-color: #33b5e5;
                color: #ffffff;
                 box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
                }
                .menu li:hover {
                     background-color: #0099cc;
                }
        </style>
    </head>
    <body>
        <div class="header">
            <h1>Champion School Platform</h1>
        </div>
        <div class="row">
            <div class="col-2 menu">
             <ul>
            <li>Student profile</li>
            <li>Departments</li>
            <li>Results</li>
            <li>recorded Lectures</li>
            </ul>
        </div>
        <div class="col-9" style="text-align: center;">
            <h1>Login</h1>
            <p>You should login with your registered username and password you created during your registration.</p>
            <form action="login" method="POST">
                <label for="username">User Name:</label>
                <input type="text" id="username" name="username" required><br><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br><br>
                <input type="submit" value="Login">
            </form>
        </div>
        </div>
     </body>
</html>
