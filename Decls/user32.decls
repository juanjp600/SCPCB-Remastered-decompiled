.lib "user32.dll"

api_getclientrect%(hwnd%, lpRect*):"GetClientRect"
api_getdesktopwindow%():"GetDesktopWindow"
api_getfocus%():"GetFocus"
api_setwindowlong%(hwnd%, nIndex%, dwNewLong%):"SetWindowLongA"
api_setwindowpos%(hwnd%, hWndInsertAfter%, x%, y%, cx%, cy%, wFlags%):"SetWindowPos"
