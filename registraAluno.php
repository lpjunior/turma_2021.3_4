<?php

    require_once('repository/AlunoRepository.php');

    # https://www.php.net/manual/pt_BR/filter.filters.sanitize.php
    $nome = filter_input(INPUT_POST, 'nome', FILTER_SANITIZE_SPECIAL_CHARS);
    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_EMAIL);
    $matricula = filter_input(INPUT_POST, 'matricula', FILTER_SANITIZE_NUMBER_INT);

    $msg = "";
    if(fnAddAluno($nome, $email, $matricula)) {
        $msg = "Sucesso ao gravar";
    } else {
        $msg = "Falha na gravação";
    }

    # redirect para a página de formulário
    header("location: formulario-cadastro-aluno.php?notify={$msg}");
    exit;