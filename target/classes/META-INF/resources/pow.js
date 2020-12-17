
$(document).ready(function() {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const wojewodztwo = urlParams.get('wojewodztwo');
    console.log(wojewodztwo);

    $.ajax({
        url: "/graphql",
        contentType: "application/json",
        type:'POST',
        data: JSON.stringify({ query:'{allPowiat(Wojewodztwo:' + wojewodztwo + ')}' }),
        success: function(result) {
            console.log(JSON.stringify(result))
            $.each(result.data.allPowiat, function(index, el) {
                $( "#nazwa-powiatu" ).append("<ion-item href=/gmina.html?wojewodztwo=" + wojewodztwo + "&powiat=\"" + result.data.allPowiat[index] + "\"> \
                                              <ion-avatar slot=\"start\"><img src=\"/img/h.jpg\"></ion-avatar> \
                                              <ion-label>" + result.data.allPowiat[index].toUpperCase() + "</ion-label></ion-item>");
                                                                    
            });
        }
    })
});
