<?php

    require_once('repository/AlunoRepository.php');

    $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);

    $msg = "";
    if(fnDeleteAluno($id)) {
        $msg = "Sucesso ao apagar";
    } else {
        $msg = "Falha ao apagar";
    }

    # redirect para a página de formulário
    header("location: listagem-de-alunos.php?notify={$msg}");
    exit;