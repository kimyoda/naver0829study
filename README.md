# naver0829study
네이버 클라우드 과정 3기 수업 


git-bash
1. git init - git 과 연동할 폴더 초기화
2. git remote add origin https://github.com/kimyoda/naver0829study.git -  git 원격저장소에 새로 
   오류가 나서 새로운 깃 저장소랑 연결이 안될경우
   git remote set-url origin https://github.com/kimyoda/naver0829study.git 
4. git branch 조회
5. git add . 또는 git add 파일명 : 해당 파일들을 로컬 저장소에 추가
6. git commit - m 메세지 - 해당 메세지와 함께 위의 파일들을 로컬저장소에 커밋
7. git push orign 브랜치명 - 원격저장소의 해당 브랜치에 소스 보내기
    - 반대로 원격 저장소의 수정된 내용을 가져올 경우
    - git pull origin 브랜치명
7. git add(경고무시)
8. git commit -m “파일 명”(공백이 있을 경우 “”을 붙여야 한다)
9. git push origin main(push로 할 것)

참고사항

- [cat.REMD.md](http://cat.REMD.md)는 cat은 REMD.md 즉 내용을 보여주는 명령어
- 원격저장소에서 저장했을 때는 항상 pull할 것
  
처음에 한번만 이메일과 유저명 확인
git config--global user.name "[사용자명]"

git config--global user.email "[사용자이메일]"
