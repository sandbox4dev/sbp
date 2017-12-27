(function ($) {
    $(document).ready(function () {

        function getInfo() {
            $.ajax({
                type: "GET",
                url: '../application/metrics/jvm.memory.used',
                success: function (data) {
                    $('#instanceInfo').html("");
                    $('#instanceInfo').append(
                        "<div class='data-container'>" +
                        "<p>Memory used:" + "<b>" + data.measurements[0].value/1024/1024 + "</b></p>" +
                        "<p>Author:" + "<b>Vyacheslav Francishko</b></b></p>" +
                        "<div class='data-container'>");

                },
                error: function (data) {
                    $('#instanceInfo').text("");
                    $('#instanceInfo').append("Server error!");
                }
            });
        }

        $('#getAppInfo').on('click', getInfo);
        (function () {
            getInfo();
        })();
    })
}(jQuery));



