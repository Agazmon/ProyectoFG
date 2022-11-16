<?php
    //Función autoload para las clases de php
    spl_autoload_register('autoload');
    function autoload($clase, $dir=null){
        if(is_null($dir)){
            $dir = realpath(dirname(__FILE__)); 
        }
        foreach(scandir($dir) as $file){
            if(is_dir($dir."/".$file) AND substr($file,0,1) != "."){
                autoload($clase, $dir."/".$file);
            }
            else if (is_file($dir."/".$file) AND $file == $clase.".php"){
                require($dir."/".$file);
            }
        }
    }
?>
