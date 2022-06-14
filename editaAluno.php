<?php

    require_once('repository/AlunoRepository.php');

    $id = filter_input(INPUT_POST, 'idAluno', FILTER_SANITIZE_NUMBER_INT);
    $nome = filter_input(INPUT_POST, 'nome', FILTER_SANITIZE_SPECIAL_CHARS);
    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_EMAIL);
    $matricula = filter_input(INPUT_POST, 'matricula', FILTER_SANITIZE_NUMBER_INT);

    $msg = "";
    if(fnUpdateAluno($id, $nome, $email, $matricula)) {
        $msg = "Sucesso ao gravar";
    } else {
        $msg = "Falha na gravação";
    }

    # redirect para a página de formulário
    header("location: formulario-edita-aluno.php?notify={$msg}&id=$id");
    exit;