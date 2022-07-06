<?php

    require_once('Connection.php');

    # CRUD
    function fnLogin($email, $senha) {
        $con = getConnection();

        $sql = "select id, email, created_at as createdAt from login where email = :pEmail and senha = :pSenha";

        $stmt = $con->prepare($sql);
        $stmt->bindParam(":pEmail", $email);
        $stmt->bindValue(":pSenha", md5($senha));

        if($stmt->execute()) {
            return $stmt->fetch(PDO::FETCH_OBJ);
        }

        return null;
    }

    function fnAtualizaSenha($email, $senha) {
        $con = getConnection();

        $sql = "update login set senha = :pSenha where email = :pEmail";

        $stmt = $con->prepare($sql);
        $stmt->bindParam(":pEmail", $email);
        $stmt->bindValue(":pSenha", md5($senha));

        if($stmt->execute()) {
            return true;
        }

        return false;
    }