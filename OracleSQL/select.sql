/*
SELECT��
*/
--board ���̺����� bwriter�� ȫ�浿�� ���� ��� �÷��� �����Ͷ�
select *
from board
where bwriter='ȫ�浿';
--bwriter�� ȫ�浿�� bno,btitle,bwriter�÷��� �������ÿ�
select bno,btitle,bwriter
from board
where bwriter='ȫ�浿';
-- bno�� 1���� 10������ �Խù��� �������ÿ�
select *
from board
where bno>=1 and bno<=10;
--bno�� 1���� 10������ �Խù��� �������ÿ�. between ������ ���� �ͺ��� ������.
select *
from board
where bno between 1 and 10;
--bwriter�� 'ȫ'�� �����ϴ� �Խù��� bno,btitle,bwriter�� �������ÿ�.
select bno,btitle,bwriter
from board
where bwriter like '%ȫ%';
--�Խù��� ���� �߿� '�ڹ�'�� ���ԵǾ� �ִ� �Խù��� bno,btitle,bwriter�� �������ÿ�
select bno,btitle,bwriter
from board
where btitle like '%�ڹ�%';
--�Խù��� ����, �����߿� '�ڹ�'�� ���ԵǾ� �ִ� �Խù��� bno,btitle,bwriter�� �������ÿ�
select bno,btitle,bwriter
from board
where btitle like '%�ڹ�%' or bcontent like '%�ڹ�%';
--�۾��̰� '���ڹ�', '��浿', '�����'�� �Խù��� ��ȣ,����,�۾��̸� �������ÿ�.
select bno,btitle,bwriter
from board
where BWRITER ='���ڹ�' or BWRITER ='��浿' or BWRITER ='�����';
--�۾��̰� '���ڹ�', '��浿', '�����'�� �Խù��� ��ȣ,����,�۾��̸� �������ÿ�.
select bno,btitle,bwriter
from board
where BWRITER in ('���ڹ�','��浿','�����');
--÷�� ������ ���� �Խù��� �������ÿ�.
select *
from board
where boriginalfilename is null;
--÷�� ������ �ִ� �Խù��� �������ÿ�.
select *
from board
where boriginalfilename is not null;
--�Խù��� �ۼ��� ����� �̸��� �������ÿ�(�ߺ� �����ϰ�)
select distinct bwriter
from board;
--�Խñ��� �� ��¥�� 2016���� �Խñ��� �������ÿ�
select *
from board
where '2016.01.01'<=bdate and bdate<='2016.12.31';

select *
from board
where bdate between '2016.01.01' and '2016.12.31';

--bno->��ȣ, btitle->���� , bwriter->�۾��� �� �÷� �̸��� �����ؼ� �������ÿ�. (as�� ������ ����)
select bno as ��ȣ,btitle as ����,bwriter �۾���
from board;

/*
����
*/
--�Խù��� ��ȣ�� �������� �ø��������� �������ÿ�.
select *
from board
order by bno asc;
--��������
select *
from board
order by bno desc;

--2017�⵵�� �ۼ��� �Խù��� ��ȣ�� �������� ���������ɷ� �������ÿ�
select *
from board
where bdate>='2017.01.01' --between'2017.1.1' and '2017.12.31'
order by bno desc;
--�۾��̸� �������� 1�� ����(�ø�)�ϰ� �� ��¥�� �������� 2������(����) �Ͻÿ�
select *
from board
order by BWRITER ASC ,bdate desc;

/*
����¡ ó��
*/
--����Ǿ� �ִ� ������� �� ��ȣ �ű��
select rownum, bno,btitle,bwriter,bdate,bhitcount
from board;
--���� �� , �� ��ȣ �ű��
select rownum,bno,btitle,bwriter,bdate,bhitcount
from (select bno,btitle,bwriter,bdate,bhitcount from board order by bno desc);
--Ư�� ���ȣ ���ϸ� ��������(žn�� ��������)
select rownum,bno,btitle,bwriter,bdate,bhitcount
from (select bno,btitle,bwriter,bdate,bhitcount from board order by bno desc)
where rownum<=10;
--���� ���ȣ�� �� ���ȣ ������ �Խù� ��������
select *
from(
select rownum as r,bno,btitle,bwriter,bdate,bhitcount
from (select bno,btitle,bwriter,bdate,bhitcount from board order by bno desc)
--where rownum<=(pageNo*rowsPerPage)
where rownum<=(2*15)
)
--where r>=((pageNo-1)*rowsPerPage+1);
where r>=((2-1)*15+1);

/*
�� �� ���ϱ�
*/
--��ü ��� ���ϱ�
--*�� ����ϸ� ��ü���, �÷� �̸� �����ϸ� �ش� Į���� null���� �� ���� ������ ���� ����.
select count(*) from board;
select count(bno) from board;
select count(boriginalfilename) from board;

--Ư�� ���ǿ� �´� ��� ���ϱ� 
--��ü �࿡�� bwriter�� ȫ�浿�� �ƴ� ����� ���
select count(*) from board where bwriter<> 'ȫ�浿';


---------------