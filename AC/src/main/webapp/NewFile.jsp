<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>
    <title>페이징</title>
    
    
    
    <style>
    * {
  margin: 0;
  padding: 0;
}

div.app {
  width: 100%;
}

table,
td {
  border: 1px solid #333;
  border-collapse: collapse;
}

table {
  width: 100%;
  margin-top: 20px;
}

td,
th {
  padding: 3px;
}

thead,
tfoot {
  background-color: #333;
  color: #fff;
}

td.center {
  text-align: center;
}

div.paging {
  width: 100%;
  display: inline-flex;
  align-items: center;
  margin-top: 20px;
  justify-content: center;
}

div.paging>i,
div.paging>div.pages {
  margin: 0 10px;
}

div.paging>i,
div.paging>div.pages>span {
  margin: 0 3px;
  cursor: pointer;
}

span.active {
  color: orangered;
  font-weight: bold;
}
    </style>
  </head>

  <body>
    <div class="app">
      <table id="tblTodo">
        <caption></caption>
        <colgroup>
          <col width="10%" />
          <col width="10%" />
          <col width="*" />
          <col width="10%" />
        </colgroup>
        <thead>
          <tr>
            <th>ID</th>
            <th>User ID</th>
            <th>Title</th>
            <th>Completed</th>
          </tr>
        </thead>
        <tbody>
        </tbody>
      </table>

      <div class="paging">
        <!-- Icon은 fontawesome에서 가져왔습니다. -->
        <i class="fa-solid fa-angles-left" id="first_page"></i>
        <i class="fa-solid fa-angle-left" id="prev_page"></i>
        <div class="pages">
          <span class="active">1</span>
          <span>2</span>
          <span>3</span>
          <span>4</span>
          <span>5</span>
        </div>
        <i class="fa-solid fa-angle-right" id="next_page"></i>
        <i class="fa-solid fa-angles-right" id="last_page"></i>
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
    const countPerPage = 10; // 페이지당 데이터 건수
    const showPageCnt = 5; // 화면에 보일 페이지 번호 개수

    $(function() {
      const todosUrl = 'https://jsonplaceholder.typicode.com/todos';
      axios.get(todosUrl)
        .then(res => {
          // 총 200개의 todo(userId, id, title, completed)를 가져옵니다.
          //console.log(res.data);
          todoData = res.data;

          // 별도의 서버에 페이지별로 요청하는 게 아니기 때문에
          // 데이터를 한 번에 가져와서 페이지별로 화면에 출력합니다.
          setTable(1);
          setPaging(1);
        })
        .catch(err => console.error(err))
        .then(() => {
          // finally
        });

      $(document).on('click', 'div.paging>div.pages>span', function() {
        if (!$(this).hasClass('active')) {
          $(this).parent().find('span.active').removeClass('active');
          $(this).addClass('active');

          setTable(Number($(this).text()));
        }
      });

      $(document).on('click', 'div.paging>i', function() {
        const totalPage = Math.floor(todoData.length / countPerPage) + (todoData.length % countPerPage == 0 ? 0 : 1);
        const id = $(this).attr('id');
        //console.log(id);

        if (id == 'first_page') {
          setTable(1);
          setPaging(1);
        } else if (id == 'prev_page') {
          let arrPages = [];
          $('div.paging>div.pages>span').each(function(idx, item) {
            arrPages.push(Number($(this).text()));
          });
          
          const prevPage = _.min(arrPages) - showPageCnt;
          setTable(prevPage);
          setPaging(prevPage);
        } else if (id == 'next_page') {
          let arrPages = [];
          $('div.paging>div.pages>span').each(function(idx, item) {
            arrPages.push(Number($(this).text()));
          });
          
          const nextPage = _.max(arrPages) + 1;
          setTable(nextPage);
          setPaging(nextPage);
        } else if (id == 'last_page') {
          const lastPage = Math.floor((totalPage - 1) / showPageCnt) * showPageCnt + 1;
          setTable(lastPage);
          setPaging(lastPage);
        }
      });
    });

    /**
     * 테이블에 데이터를 세팅합니다.
     * @param {int} pageNum - Page Number
     */
    function setTable(pageNum) {
      $('#tblTodo>tbody').empty();

      // filtering data
      const filteredData = _.slice(todoData, (pageNum - 1) * countPerPage, pageNum * countPerPage);
      //console.log(filteredData);

      let sTbodyHtml = '';
      for (let i = 0; i < filteredData.length; i++) {
        sTbodyHtml += '<tr>';
        sTbodyHtml += '  <td class="center">' + filteredData[i].id + '</td>';
        sTbodyHtml += '  <td class="center">' + filteredData[i].userId + '</td>';
        sTbodyHtml += '  <td>' + filteredData[i].title + '</td>';
        sTbodyHtml += '  <td class="center"><input type="checkbox" ' + (filteredData[i].completed ? 'checked' : '') + ' onclick="return false" /></td>';
        sTbodyHtml += '</tr>';
      }
      $('#tblTodo>tbody').append(sTbodyHtml);
    }

    /**
     * 페이징 정보를 세팅합니다.
     * @param {int} pageNum - Page Number
     */
    function setPaging(pageNum) {
      const currentPage = pageNum;
      const totalPage = Math.floor(todoData.length / countPerPage) + (todoData.length % countPerPage == 0 ? 0 : 1);
      //console.log(currentPage, totalPage);

      showAllIcon();

      if (currentPage <= showPageCnt) {
        $('#first_page').hide();
        $('#prev_page').hide();
      }
      if (
        totalPage <= showPageCnt ||
        Math.floor((currentPage - 1) / showPageCnt) * showPageCnt + showPageCnt + 1 > totalPage
      ) {
        $('#next_page').hide();
        $('#last_page').hide();
      }

      let start = Math.floor((currentPage - 1) / showPageCnt) * showPageCnt + 1;
      let sPagesHtml = '';
      for (const end = start + showPageCnt; start < end && start <= totalPage; start++) {
        sPagesHtml += '<span class="' + (start == currentPage ? 'active' : '') + '">' + start + '</span>';
      }
      $('div.paging>div.pages').html(sPagesHtml);
    }

    function showAllIcon() {
      $('#first_page').show();
      $('#prev_page').show();
      $('#next_page').show();
      $('#last_page').show();
    }
    
    </script>
  </body>

</html>