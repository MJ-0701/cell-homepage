var render = {
    init: function () {
        var _this = this;

        $('#diary').on('click', function () {
            _this.diary();
        });
    },
    diary: function () {
        var id = $('#id').val();
        alert("클릭 확인");

        $.ajax({
            type: 'GET',
            url: '/diary'
        }).done(function () {
            // window.location.href = '/diary';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

render.init();

