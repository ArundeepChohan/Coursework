#!/bin/bash
awk 
'
BEGIN
{
}
{
thee+=gsub(/[tT][hH][eE][eE]/,"you")
thou+=gsub(/[tT][hH][oO][Uu]/,"you")
thine+=gsub(/[tT][hH][iI][nN][eE]/,"your")
thy+=gsub(/[tT][hH][yY]/,"your")
art+=gsub(/[aA][rR][tT]/,"are")
shall+=gsub(/[sS][hH][aA][lL][lL]/,"will")
wilt+=gsub(/[wW][iI][lL][tT]/,"will")
ere+=gsub(/[eE][rR][eE]/,"before")
doth+=gsub(/[dD][oO][tT][hH]/,"does")


gsub("[tT][hH][eE][eE]","you");
gsub("[tT][hH][oO][Uu]","you");
gsub("tT][hH][iI][nN][eE]","your")
gsub("[tT][hH][yY]","your")
gsub("[aA][rR][tT]","are")
gsub("[sS][hH][aA][lL][lL]","will")
gsub("[wW][iI][lL][tT]","will")
gsub("[eE][rR][eE]","before")
gsub("[dD][oO][tT][hH]","does")
;print
}
END
{
printf "thou: " thou "thee: " thee " thine: "thine " thy: "thy " art: "art " shall: "shall" wilt: " wilt "ere: " ere " doth: " doth >"/dev/tty"
}
'
shakes.text>output