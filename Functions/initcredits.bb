Function initcredits%()
    Local local0.fonts
    Local local1.creditsline
    Local local2%
    Local local3$
    local0 = (First fonts)
    local2 = openfile("Credits.txt")
    local0\Field2[$00] = loadfont_strict(scpmodding_processfilepath("GFX\font\cour\Courier New.ttf"), (Int (((Float graphicheight) / 1024.0) * 21.0)), $00, $00, $00)
    local0\Field2[$01] = loadfont_strict(scpmodding_processfilepath("GFX\font\courbd\Courier New.ttf"), (Int (((Float graphicheight) / 1024.0) * 35.0)), $00, $00, $00)
    If (creditsscreen = $00) Then
        creditsscreen = loadimage_strict(scpmodding_processfilepath("GFX\creditsscreen.pt"))
    EndIf
    Repeat
        local3 = readline(local2)
        local1 = (New creditsline)
        local1\Field0 = local3
    Until (eof(local2) <> 0)
    Delete (First creditsline)
    creditstimer = 0.0
    Return $00
End Function
