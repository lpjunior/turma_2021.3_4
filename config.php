<?php
    # https://www.php.net/manual/pt_BR/features.cookies.php

    # https://www.php.net/manual/pt_BR/features.sessions.php
    session_start();
    
    # https://www.php.net/manual/pt_BR/function.date-default-timezone-set.php
    date_default_timezone_set('America/Sao_Paulo');

    # https://www.php.net/manual/pt_BR/function.array-key-exists
    if(!array_key_exists('login', $_SESSION) || empty(isset($_SESSION['login'])))
    {
        header("location: errorPage.php?notify=acesso-negado");
        exit;
    }