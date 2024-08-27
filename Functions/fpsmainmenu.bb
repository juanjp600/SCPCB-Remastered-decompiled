Function fpsmainmenu%()
    Local local0.fonts
    Local local1.fps_settings
    local0 = (First fonts)
    local1 = (First fps_settings)
    If (showfps <> 0) Then
        aasetfont(local0\Field1)
        aatext($14, (graphicheight - $32), ("FPS: " + (Str local1\Field7)), $00, $00, 1.0)
        aasetfont(local0\Field0[$00])
    EndIf
    Return $00
End Function
