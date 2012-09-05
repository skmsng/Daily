プッシュ  
cd /Volumes/WORK/ict/workspace/Daily  
git add .  
git commit -m 'commit message'  
git push  

クローン  
cd /Volumes/WORK/ict/workspace/Daily  
git clone https://github.com/smnksg/Daily.git

ステータス  
git status

＜GitHubに残ったファイルを削除＞  
git rm ファイル名  
git add .  
git commit -m 'commit message'  
git push  

pwd (print working directory)  
カレントディレクトリの確認  

mkdir  
ディレクトリの作成  
mkdir directory)   

rm  
指定したファイルを削除できる。ワイルドカードの使用もできる。  
rm -rf directory	ディレクトリごと警告無しで削除  
-f	同名ファイルを警告せずに削除する  
-i	ファイルの削除前に問い合わせる  
-r	ディレクトリごと削除する  
-v	処理内容を表示する  

mv  
ファイルやディレクトリの移動を行う。ファイル名の変更にも使用される。  
mv sample user/newdirectory	sampleを移動  
mv sample sample2	sampleからsample2にファイル名を変更  
-i	上書きするファイルは問い合わせる  
-f	同名ファイルを警告せずに上書きする  
-v	処理内容を表示する  
-u	同名ファイルは最終更新日付を比較して古いときのみ上書きする  

cp  
ファイルやディレクトリをコピーする。複数ファイルを指定するときはスペースで区切る。ワイルドカードの使用もできる。  
cp file1 file2	違う名前で同一ディレクトリにコピー  
cp /home/user1/*.html /home/user2	user1以下のすべてのHTMLファイルをuser2にコピー  