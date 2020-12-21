
$(document).ready(function() {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');
    console.log(id);
    var map = new ol.Map();

    $.ajax({
        url: "/graphql",
        contentType: "application/json",
        type:'POST',
        data: JSON.stringify({ query:'{jednostka(Id:' + id + '){Nazwa_jednostki Ulica, Numer_budynku Numer_lokalu Kod_pocztowy Miejscowosc Telefon_kontaktowy Adres_email Rodzaj_ratownictwa}}' }),
        success: function(result) {
            console.log(JSON.stringify(result))
                $( "#dane-jednostki" ).append("<h1>" + result.data.jednostka.Nazwa_jednostki + "</h1><br>" +
                   "<h2>" + result.data.jednostka.Ulica + " " + result.data.jednostka.Numer_budynku +"</h2>" +
                   "<h2>" + result.data.jednostka.Kod_pocztowy + " " + result.data.jednostka.Miejscowosc + "</h2><br>" +
                   "<h2> Telefon : <a href=tel:\"" + result.data.jednostka.Telefon_kontaktowy + "\">" + result.data.jednostka.Telefon_kontaktowy + "</a></h2><br>" +
                   "<h2>Email : <a href=mailto:\"" + result.data.jednostka.Adres_email + "\">"+ result.data.jednostka.Adres_email +"</a></h2>"
                );
                $( "#zakres-jednostki" ).append("<h2>" + result.data.jednostka.Rodzaj_ratownictwa + "<\h2>"
                );
                var mapLink = document.getElementById("mapLink");
                mapLink.href = "/map.html?search_for=" + result.data.jednostka.Nazwa_jednostki + "";            
        }
    })
    
});