
$(document).ready(function() {
    $.ajax({
        url: "/graphql",
        contentType: "application/json",
        type:'POST',
        data: JSON.stringify({ query:'{allWojewodztwo}' }),
        success: function(result) {
            console.log(JSON.stringify(result))
            $.each(result.data.allWojewodztwo, function(index, el) {
                $( "#nazwa-wojewodztwa" ).append("<ion-item href=/powiat.html?wojewodztwo=\"" + result.data.allWojewodztwo[index] + "\"> \
                                                  <ion-avatar slot=\"start\"><img src=\"/img/h.jpg\"></ion-avatar> \
                                                  <ion-label>" + result.data.allWojewodztwo[index] + "</ion-label></ion-item>");
            });
        }
    })
});