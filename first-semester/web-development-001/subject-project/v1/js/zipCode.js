$(document).ready(function() {
    function clearZipCodeForm() {
        $("#street").val("")
        $("#neighborhood").val("")
        $("#city").val("")
        $("#uf").val("")
    }
    
    $("#zip-code").blur(function() {
        var zipCode = $(this).val().replace(/\D/g, "")

        if (zipCode != "") {
            var validateZipCode = /^[0-9]{8}$/

            if (validateZipCode.test(zipCode)) {
                $("#street").val("Carregando...")
                $("#neighborhood").val("Carregando...")
                $("#city").val("Carregando...")
                $("#uf").val("Carregando...")
               
                $.getJSON("https://viacep.com.br/ws/" + zipCode + "/json/?callback=?", function(data) {
                    if (!("erro" in data)) {
                        $("#street").val(data.patio)
                        $("#neighborhood").val(data.neighborhood)
                        $("#city").val(data.locality)
                        $("#uf").val(data.uf)
                    } else {
                        clearZipCodeForm()
                        alert("CEP não encontrado.")
                    }
                });
            } else {
                clearZipCodeForm()
                alert("Formato de CEP inválido.")
            }
        } else {
            clearZipCodeForm()
        }
    })
})
