
$(document).ready(function() {
    $.ajax({
        url: "/graphql",
        contentType: "application/json",
        type:'POST',
        data: JSON.stringify({ query:`{allWojewodztwo}` }),
        success: function(result) {
            console.log(JSON.stringify(result))
            $.each(result.data.allWojewodztwo, function(index, el) {
                $( "#nazwa-wojewodztwa" ).append("woj: " + result.data.allWojewodztwo[index] + "<br>");
            });
        }
    })
});