
$(document).ready(function() {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const wojewodztwo = urlParams.get('wojewodztwo');
    const powiat = urlParams.get('powiat');
    const gmina = urlParams.get('gmina');
    console.log(wojewodztwo);
    console.log(powiat);
    console.log(gmina);
    console.log('{selectedJednostka(w:' + wojewodztwo + ',p:'+ powiat +',g:'+ gmina +')}');

    $.ajax({
        url: "/graphql",
        contentType: "application/json",
        type:'POST',
        data: JSON.stringify({ query:'{selectedJednostka(w:' + wojewodztwo + ',p:'+ powiat +',g:'+ gmina +'){id Nazwa_jednostki}}' }),
        success: function(result) {
            console.log(JSON.stringify(result))
            $.each(result.data.selectedJednostka, function(index, el) {
                $( "#nazwa-jednostki" ).append("<ion-item href=/dane_jednostki.html?id=" + result.data.selectedJednostka[index].id + "> \
                                              <ion-avatar slot=\"start\"><img src=\"/img/h.jpg\"></ion-avatar> \
                                              <ion-label>" + result.data.selectedJednostka[index].Nazwa_jednostki + "</ion-label></ion-item>");
            });
        }
    })
});
