<?php
    function converterBase64($file) {
        switch($file['error']) {
            case UPLOAD_ERR_OK:
                break;
            case UPLOAD_ERR_INI_SIZE:
            case UPLOAD_ERR_FORM_SIZE:
                echo 'arquivo excedeu o tamanho limite';
                exit;
            case UPLOAD_ERR_NO_FILE:
                echo 'arquivo não enviado';
                exit;
            default: 
                echo 'erro desconhecido';
                exit;
        }

        if($file['size'] > 10000000) {
            echo 'tamanho superior a 10mb';
        }

        $tipoValidos = array(
            'jpg' => 'image/jpeg',
            'jpeg' => 'image/jpeg',
            'png' => 'image/png'
        );
            
        if(!array_search($file['type'], $tipoValidos, true)) {
            echo 'não é valido '; 
        }

        $base64 = base64_encode(file_get_contents($file['tmp_name']));
        return sprintf("data:%s;base64,%s", $file['type'], $base64);
    }