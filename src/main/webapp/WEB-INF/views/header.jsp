<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<div class="container">
    <div class="header">
        <div class="header-right">
            <ul>
                <li>
                    <img class="logo" src="../../assets/img/logo.jpeg">
                </li>
                <li>
                    <span>Globe Images</span>
                </li>
            </ul>
        </div>
        <div class="header-left">
            <ul>
                <li><span></span><a>Home</a></li>
                <li><span></span><a>My Picture</a></li>
                <li><span></span><a>Upload</a></li>
                <li><span></span><a>Shopping car</a></li>
                <li class="popbox"><span></span><a class='open' href='#'>User</a>

                    <div class='collapse'>
                        <div class='box'>
                            <button>Edit Profile</button>
                            <button>Logout</button>

                        </div>
                    </div>
                </li>
            </ul>
        </div>

    </div>
    <script type='text/javascript' charset='utf-8'>
        $(document).ready(function () {
            $('.popbox').popbox();
        });
    </script>
</div>