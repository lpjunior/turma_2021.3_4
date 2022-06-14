<?php
    #https://www.php.net/manual/pt_BR/function.session-start
    session_start();

    require_once('repository/LoginRepository.php');

    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_EMAIL);
    $senha = filter_input(INPUT_POST, 'senha', FILTER_SANITIZE_SPECIAL_CHARS);

    $page = "errorPage.php?notify=acesso-negado";

    if($_SESSION['login'] = fnLogin($email, $senha)) {
        $page = "listagem-de-alunos.php";
    }
    
    header("location: {$page}");
    exit;