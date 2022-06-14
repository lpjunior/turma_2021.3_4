<?php
    require_once('repository/AlunoRepository.php');
    $nome = filter_input(INPUT_POST, 'nomeAluno', FILTER_SANITIZE_SPECIAL_CHARS);

    header("location: listagem-de-alunos.php?nome={$nome}");
    exit;