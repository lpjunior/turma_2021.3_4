<?php
    require_once('Connection.php');

    # CRUD

    function fnAddAluno($nome, $email, $matricula) {
        $con = getConnection();
        
        # SQL Injection
        $sql = "insert into aluno (nome, email, matricula) values (:pNome, :pEmail, :pMatricula)";
        
        $stmt = $con->prepare($sql);
        $stmt->bindParam(":pNome", $nome); 
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
    
    function fnUpdateAluno($id, $nome, $email, $matricula) {
        $con = getConnection();
                
        $sql = "update aluno set nome = :pNome, email = :pEmail, matricula = :pMatricula where id = :pID";
        
        $stmt = $con->prepare($sql);
        $stmt->bindParam(":pID", $id); 
        $stmt->bindParam(":pNome", $nome); 
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