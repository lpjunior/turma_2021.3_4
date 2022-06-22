<?php
    require_once('repository/AlunoRepository.php');
    session_start();

    $id = filter_input(INPUT_POST, 'idAluno', FILTER_SANITIZE_NUMBER_INT);
    $nome = filter_input(INPUT_POST, 'nome', FILTER_SANITIZE_SPECIAL_CHARS);
    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_EMAIL);
    $matricula = filter_input(INPUT_POST, 'matricula', FILTER_SANITIZE_NUMBER_INT);

    if(fnUpdateAluno($id, $nome, $email, $matricula)) {
        $msg = "Sucesso ao gravar";
    } else {
        $msg = "Falha na gravação";
    }
    
    $_SESSION['id'] = $id;
    $page = "formulario-edita-aluno.php";
    setcookie('notify', $msg, time() + 10, "sga/{$page}", 'localhost');
    header("location: {$page}");
    exit;