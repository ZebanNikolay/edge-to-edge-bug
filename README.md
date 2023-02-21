# edge-to-edge-bug
Project demonstrates insets compat issue. The issue happens only on Android 8 and 9.

Issue: 

##Devices:
###Android 8:
- Samsung J7
- Samsung A5
- Sony Xperia XA1
###Android 9:
- Nokia 8

## WTR
1. Press the "Next" button
2. Wait for the toast "Done" to appear
3. Press the "Previous" button

## Expected behavior
The First Fragment should has height and width equal to the parent size "match_parent".

## Actual behavior
The First Fragment has height and width equal to zero.

<img src="https://github.com/ZebanNikolay/edge-to-edge-bug/blob/master/img/edge-to-edge-bug-video.gif" width="720" height="1280">
