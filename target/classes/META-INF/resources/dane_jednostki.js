
$(document).ready(function() {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');
    console.log(id);

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
        }
    })
    
    let map;
    let service;
    let infowindow;
    let qry;

    function initMap() {
      const glowno = new google.maps.LatLng(51.9661, 19.7178);
      infowindow = new google.maps.InfoWindow();
      map = new google.maps.Map(document.getElementById("map"), {
        center: glowno,
        zoom: 14,
      });

      qry = "ochotnicza straz pozarna";

      console.log(qry);

      const request = {
        query: qry,
        fields: ["name", "geometry"],
      };
      service = new google.maps.places.PlacesService(map);
      service.findPlaceFromQuery(request, (results, status) => {
        if (status === google.maps.places.PlacesServiceStatus.OK) {
          for (let i = 0; i < results.length; i++) {
            createMarker(results[i]);
          }
          map.setCenter(results[0].geometry.location);
        }
      });
    }

    jQuery(document).ready(function($) {
        initMap();
    });

});