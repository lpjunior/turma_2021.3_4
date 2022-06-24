<?php

    require_once('repository/AlunoRepository.php');
    session_start();

    if(fnDeleteAluno($_SESSION['id'])) {
        $msg = "Sucesso ao apagar";
    } else {
        $msg = "Falha ao apagar";
    }

    # apagar sessão
    unset($_SESSION['id']);

    $page = "listagem-de-alunos.php";
    setcookie('notify', $msg, time() + 10, "/sga/{$page}", 'localhost');
    header("location: {$page}");
    exit;