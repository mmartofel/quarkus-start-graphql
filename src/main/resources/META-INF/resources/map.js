
$(document).ready(function() {

var map = L.map('mapid');
var url = 'https://nominatim.openstreetmap.org/search/format=json';
var data;
var lat;
var lon;
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const nazwa = urlParams.get('search_for');
console.log(nazwa);


$.ajax({
    url:  'https://nominatim.openstreetmap.org/search/'+ nazwa +'?format=json',
    contentType: "application/json",
    type:'GET',
    data: data,
    success: function(result) {
        console.log(result[0].lat);
        lat = result[0].lat;
        console.log(result[0].lon);
        lon = result[0].lon;
        console.log(JSON.stringify(result))
        map.setView([lat,lon], 16);
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

        L.marker([lat,lon]).addTo(map)
            .bindPopup(result[0].display_name)
            .openPopup();
    }
})            


});
