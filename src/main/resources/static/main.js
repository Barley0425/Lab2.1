window.onload = function() {
   $(".like").click((e) => { // Навешиваем обработчик клика на все кнопки с классом "like"
      var btn = $(e.currentTarget); // Получаем нажатую кнопку
      var postId = btn.attr("data-post-id"); // Извлекаем ID поста из атрибута data-post-id
      btn.attr("disabled", "disabled"); // Отключаем кнопку на время выполнения запроса (чтобы избежать множественных кликов)
      $.post("/post/" + postId + "/like", (data) => {  // Отправляем POST‑запрос на сервер
        btn.text("" + data + " ❤"); // Обновляем текст кнопки: показываем новое количество лайков
        btn.removeClass("btn-secondary"); // Меняем стили кнопки: убираем серый цвет, добавляем красный
        btn.addClass("btn-danger"); // Включаем кнопку обратно после получения ответа
      });
   });
};