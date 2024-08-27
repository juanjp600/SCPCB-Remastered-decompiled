Function updatelauncher%()
    Local local0.fonts
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7$
    Local local8%
    Local local9%
    local0 = (First fonts)
    menuscale = 1.0
    graphics3dext($258, $1F4, $00, $02)
    setbuffer(backbuffer())
    realgraphicwidth = graphicwidth
    realgraphicheight = graphicheight
    local0\Field0[$00] = loadfont_strict(scpmodding_processfilepath("GFX\font\cour\Courier New.ttf"), $12, $00, $00, $00)
    setfont(local0\Field0[$00])
    menuwhite = loadimage_strict(scpmodding_processfilepath("GFX\menu\menuwhite.png"))
    menublack = loadimage_strict(scpmodding_processfilepath("GFX\menu\menublack.png"))
    maskimage(menublack, $FF, $FF, $00)
    launcherimg = loadimage_strict(scpmodding_processfilepath("GFX\menu\launcher.png"))
    buttonsfx = loadsound_strict(scpmodding_processfilepath("SFX\Interact\Button.ogg"))
    For local1 = $00 To $03 Step $01
        arrowimg(local1) = loadimage_strict(scpmodding_processfilepath("GFX\menu\arrow.png"))
        rotateimage(arrowimg(local1), (Float ($5A * local1)))
        handleimage(arrowimg(local1), $00, $00)
    Next
    For local1 = $01 To totalgfxmodes Step $01
        local2 = $00
        For local3 = $00 To (totalgfxmodes - $01) Step $01
            If (((gfxmodewidths(local3) = gfxmodewidth(local1)) And (gfxmodeheights(local3) = gfxmodeheight(local1))) <> 0) Then
                local2 = $01
                Exit
            EndIf
        Next
        If (local2 = $00) Then
            If (((gfxmodewidth(local1) >= $400) And (gfxmodeheight(local1) >= $300)) <> 0) Then
                If (((graphicwidth = gfxmodewidth(local1)) And (graphicheight = gfxmodeheight(local1))) <> 0) Then
                    selectedgfxmode = gfxmodes
                EndIf
                gfxmodewidths(gfxmodes) = gfxmodewidth(local1)
                gfxmodeheights(gfxmodes) = gfxmodeheight(local1)
                gfxmodes = (gfxmodes + $01)
            EndIf
        EndIf
    Next
    blinkmeterimg = loadimage_strict(scpmodding_processfilepath("GFX\blinkmeter.png"))
    apptitle(("SCP:CB Remastered Launcher " + scpmodding_version()), "")
    local4 = $00
    If (fullscreen <> 0) Then
        local4 = $00
    EndIf
    If (borderlesswindowed <> 0) Then
        local4 = $01
    EndIf
    If (((fullscreen = $00) And (borderlesswindowed = $00)) <> 0) Then
        local4 = $02
    EndIf
    Repeat
        color($00, $00, $00)
        rect($00, $00, launcherwidth, launcherheight, $01)
        mousehit1 = mousehit($01)
        color($FF, $FF, $FF)
        drawimage(launcherimg, $00, $00, $00)
        local5 = $46
        local6 = $BE
        For local1 = $00 To (gfxmodes - $01) Step $01
            color($FF, $00, $00)
            If (selectedgfxmode = local1) Then
                rect((local5 - $01), (local6 - $01), $64, $14, $00)
            EndIf
            color($FF, $FF, $FF)
            text(local5, local6, (((Str gfxmodewidths(local1)) + "x") + (Str gfxmodeheights(local1))), $00, $00)
            If (mouseon((local5 - $01), (local6 - $01), $64, $14) <> 0) Then
                color($FF, $FF, $FF)
                rect((local5 - $01), (local6 - $01), $64, $14, $00)
                If (mousehit1 <> 0) Then
                    selectedgfxmode = local1
                EndIf
            EndIf
            local6 = (local6 + $14)
            If (local6 >= $15E) Then
                local6 = $BE
                local5 = (local5 + $64)
            EndIf
        Next
        If (drawbutton($143, $DA, $F1, $1E, gfxdrivername(selectedgfxdriver), $00, $00, $00) <> 0) Then
            If (selectedgfxdriver = countgfxdrivers()) Then
                selectedgfxdriver = $01
            Else
                selectedgfxdriver = (selectedgfxdriver + $01)
            EndIf
        EndIf
        If (local4 = $00) Then
            local7 = scplang_getphrase("launcher.fullscreen")
        EndIf
        If (local4 = $01) Then
            local7 = scplang_getphrase("launcher.borderless")
        EndIf
        If (local4 = $02) Then
            local7 = scplang_getphrase("launcher.windowed")
        EndIf
        If (drawbutton($143, $119, $F1, $1E, local7, $00, $00, $00) <> 0) Then
            If (local4 = $02) Then
                local4 = $00
            Else
                local4 = (local4 + $01)
            EndIf
            If (local4 = $00) Then
                fullscreen = $01
                borderlesswindowed = $00
                local8 = $00
            ElseIf (local4 = $01) Then
                fullscreen = $00
                borderlesswindowed = $01
                local8 = $00
            ElseIf (local4 = $02) Then
                fullscreen = $00
                borderlesswindowed = $00
                local8 = $01
            EndIf
        EndIf
        If (drawbutton($161, $158, $B5, $1E, scplang_getphrase("language.name"), $00, $00, $00) <> 0) Then
        EndIf
        If (drawbutton($143, $158, $1E, $1E, "<", $00, $00, $00) <> 0) Then
            scplang_backlang()
            putinivalue("options.ini", "game", "lang", scplang_getlang())
            saveoptionsini()
        EndIf
        If (drawbutton($216, $158, $1E, $1E, ">", $00, $00, $00) <> 0) Then
            scplang_nextlang()
            putinivalue("options.ini", "game", "lang", scplang_getlang())
            saveoptionsini()
        EndIf
        If (drawbutton($29, $190, $78, $1E, scplang_getphrase("launcher.discord"), $00, $00, $00) <> 0) Then
            execfile("https://discord.gg/Q7VKS6hwEV")
        EndIf
        If (drawbutton($A5, $190, $78, $1E, scplang_getphrase("launcher.mods"), $00, $00, $00) <> 0) Then
            execfile("https://steamcommunity.com/app/2090230/workshop/")
        EndIf
        If (drawbutton($29, $1B0, $78, $1E, scplang_getphrase("launcher.reset"), $00, $00, $00) <> 0) Then
            scpsdk_resetoptions()
        EndIf
        If (drawbutton($A5, $1B0, $78, $1E, scplang_getphrase("launcher.store"), $00, $00, $00) <> 0) Then
            execfile("https://store.steampowered.com/app/2090230/SCP_Containment_Breach_Remastered/")
        EndIf
        local9 = $00
        If (borderlesswindowed <> 0) Then
            color($FF, $00, $00)
            fullscreen = $00
        Else
            color($FF, $FF, $FF)
        EndIf
        If (drawbutton($143, $197, $F1, $32, scplang_getphrase("launcher.launch"), $01, $00, $00) <> 0) Then
            graphicwidth = gfxmodewidths(selectedgfxmode)
            graphicheight = gfxmodeheights(selectedgfxmode)
            realgraphicwidth = graphicwidth
            realgraphicheight = graphicheight
            Exit
        EndIf
        flip($01)
    Forever
    putinivalue("options.ini", "options", "width", (Str gfxmodewidths(selectedgfxmode)))
    putinivalue("options.ini", "options", "height", (Str gfxmodeheights(selectedgfxmode)))
    If (fullscreen <> 0) Then
        putinivalue("options.ini", "options", "fullscreen", "true")
    Else
        putinivalue("options.ini", "options", "fullscreen", "false")
    EndIf
    If (launcherenabled <> 0) Then
        putinivalue("options.ini", "launcher", "launcher enabled", "true")
    Else
        putinivalue("options.ini", "launcher", "launcher enabled", "false")
    EndIf
    If (borderlesswindowed <> 0) Then
        putinivalue("options.ini", "options", "borderless windowed", "true")
    Else
        putinivalue("options.ini", "options", "borderless windowed", "false")
    EndIf
    If (bit16mode <> 0) Then
        putinivalue("options.ini", "options", "16bit", "true")
    Else
        putinivalue("options.ini", "options", "16bit", "false")
    EndIf
    putinivalue("options.ini", "options", "gfx driver", (Str selectedgfxdriver))
    Return $00
End Function
