<?php
    require_once('Connection.php');

    # CRUD

    function fnAddAluno($nome, $foto, $email, $matricula) {
        $con = getConnection();
        
        # SQL Injection
        $sql = "insert into aluno (nome, foto, email, matricula) values (:pNome, :pFoto, :pEmail, :pMatricula)";
        
        $stmt = $con->prepare($sql);
        $stmt->bindParam(":pNome", $nome); 
        $stmt->bindParam(":pFoto", $foto); 
        $stmt->bindParam(":pEmail", $email); 
        $stmt->bindParam(":pMatricula", $matricula); 
        
        return $stmt->execute();
    }

    function fnListAlunos() {
        $con = getConnection();

        $sql = "select * from aluno";

        $result = $con->query($sql);

        $lstAlunos = array();
        while($aluno = $result->fetch(PDO::FETCH_OBJ)) {
            array_push($lstAlunos, $aluno);
        } 

        return $lstAlunos;
    }

    function fnLocalizaAlunoPorNome($nome) {
        $con = getConnection();

        $sql = "select * from aluno where nome like :pNome limit 20";

        $stmt = $con->prepare($sql);

        $stmt->bindValue(":pNome", "%{$nome}%");

        if($stmt->execute()) {
            $stmt->setFetchMode(PDO::FETCH_OBJ);
            return $stmt->fetchAll();
        }
    }

    function fnLocalizaAlunoPorId($id) {
        $con = getConnection();

        $sql = "select * from aluno where id = :pID";

        $stmt = $con->prepare($sql);
        $stmt->bindParam(":pID", $id);

        if($stmt->execute()) {
            return $stmt->fetch(PDO::FETCH_OBJ);
        }

        return null;
    }
    
    function fnUpdateAluno($id, $nome, $foto, $email, $matricula) {
        $con = getConnection();
                
        $sql = "update aluno set nome = :pNome, foto = :pFoto, email = :pEmail, matricula = :pMatricula where id = :pID";
        
        $stmt = $con->prepare($sql);
        $stmt->bindParam(":pID", $id); 
        $stmt->bindParam(":pNome", $nome); 
        $stmt->bindParam(":pFoto", $foto); 
        $stmt->bindParam(":pEmail", $email); 
        $stmt->bindParam(":pMatricula", $matricula); 
        
        return $stmt->execute();
    }
    
    function fnDeleteAluno($id) {
        $con = getConnection();
                
        $sql = "delete from aluno where id = :pID";
        
        $stmt = $con->prepare($sql);
        $stmt->bindParam(":pID", $id);
        
        return $stmt->execute();
        //$stmt->debugDumpParams(); # faz um dump da query
    }