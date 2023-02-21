# edge-to-edge-bug
Project demonstrates insets compat issue. The issue happens only on Android 8 and 9.
## Issue description
When I use `ViewCompat.setOnApplyWindowInsetsListener` and `WindowInsetsControllerCompat` to implement immersive mode. It breaks other fragment.

[IssueTracker](https://issuetracker.google.com/u/1/issues/270049519)

## Devices:
#### Android 8:
- Samsung J7
- Samsung A5
- Sony Xperia XA1
#### Android 9:
- Nokia 8

## WTR
1. Press the "Next" button
2. Wait for the toast "Done" to appear
3. Press the "Previous" button

### Expected behavior
The First Fragment should has height and width equal to the parent size "match_parent".

### Actual behavior
The First Fragment has height and width equal to zero.

## Video
<img src="https://github.com/ZebanNikolay/edge-to-edge-bug/blob/master/img/edge-to-edge-bug-video.gif" width="360" height="640">
