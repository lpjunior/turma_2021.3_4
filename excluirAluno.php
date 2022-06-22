<?php

    require_once('repository/AlunoRepository.php');

    $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);

    if(fnDeleteAluno($id)) {
        $msg = "Sucesso ao apagar";
    } else {
        $msg = "Falha ao apagar";
    }

    $page = "listagem-de-alunos.php";
    setcookie('notify', $msg, time() + 10, "/sga/{$page}", 'localhost');
    header("location: {$page}");
    exit;