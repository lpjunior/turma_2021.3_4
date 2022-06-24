<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var timer = null;
    $('#searchName').bind('keyup', function(){
        clearTimeout(timer)
        timer = setTimeout(submitForm, 1000)
    });

    function submitForm() {
        $('#formSearchName').submit();
    }
</script>