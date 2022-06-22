<?php
    #https://www.php.net/manual/pt_BR/function.session-start
    session_start();

    require_once('repository/LoginRepository.php');

    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_EMAIL);
    $senha = filter_input(INPUT_POST, 'senha', FILTER_SANITIZE_SPECIAL_CHARS);

    $page = "listagem-de-alunos.php";

    if(!$_SESSION['login'] = fnLogin($email, $senha)) {    
        $page = "errorPage.php";

        # https://www.php.net/manual/pt_BR/function.time.php
        $expire = (time() + 10);

        setcookie('notify', 'Falha ao efetuar o login', 
            $expire, '/sga/errorPage.php', 'localhost', isset($_SERVER['HTTPS']), true);
    }
    
    header("location: {$page}");
    exit;