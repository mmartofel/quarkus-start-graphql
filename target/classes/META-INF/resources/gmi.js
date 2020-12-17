
$(document).ready(function() {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const wojewodztwo = urlParams.get('wojewodztwo');
    const powiat = urlParams.get('powiat');
    const gmina = urlParams.get('gmina');
    console.log(wojewodztwo);
    console.log(powiat);
    console.log('{allGmina(Wojewodztwo:' + wojewodztwo + ',Powiat:'+ powiat +')}');

    $.ajax({
        url: "/graphql",
        contentType: "application/json",
        type:'POST',
        data: JSON.stringify({ query:'{allGmina(Wojewodztwo:' + wojewodztwo + ',Powiat:'+ powiat +')}' }),
        success: function(result) {
            console.log(JSON.stringify(result))
            $.each(result.data.allGmina, function(index, el) {
                $( "#nazwa-gminy" ).append("<ion-item href=/jednostka.html?wojewodztwo=" + wojewodztwo + "&powiat=" + powiat + "&gmina=\"" + result.data.allGmina[index] + "\"> \
                                              <ion-avatar slot=\"start\"><img src=\"/img/h.jpg\"></ion-avatar> \
                                              <ion-label>" + result.data.allGmina[index] + "</ion-label></ion-item>");
            });
        }
    })
});
