Function drawoptionstooltip%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5#, arg6%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6$
    Local local7$
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13.fonts
    local0 = ((6.0 * menuscale) + (Float arg0))
    local1 = ((6.0 * menuscale) + (Float arg1))
    local2 = ((Float arg2) - (12.0 * menuscale))
    local3 = ((Float arg3) - (12.0 * menuscale))
    local4 = $00
    local5 = $00
    local6 = ""
    local7 = ""
    local8 = $00
    local9 = $00
    local10 = $00
    local11 = $00
    local12 = $00
    local13 = (First fonts)
    aasetfont(local13\Field0[$00])
    color($FF, $FF, $FF)
    Select lower(arg4)
        Case "bump"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.bumpmapping")) + chr($22)) + " ") + scplang_getphrase("tooltips.bumpmapping2"))
            local7 = scplang_getphrase("tooltips.notingame")
            local8 = $FF
        Case "vsync"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.vsync")) + chr($22)) + " ") + scplang_getphrase("tooltips.vsync2"))
        Case "antialias"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.antialiasing")) + chr($22)) + " ") + scplang_getphrase("tooltips.antialiasing2"))
            local7 = scplang_getphrase("tooltips.fullscreenonly")
            local8 = $FF
        Case "roomlights"
            local6 = scplang_getphrase("tooltips.roomlights")
        Case "gamma"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.gammacorrection")) + chr($22)) + " ") + scplang_getphrase("tooltips.gammacorrection2"))
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (((((scplang_getphrase("tooltips.currentval") + " ") + (Str (Int (arg5 * 100.0)))) + "% (") + scplang_getphrase("tooltips.defaultis")) + " 100%)")
        Case "texquality"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.lodbias")) + chr($22)) + " ") + scplang_getphrase("tooltips.lodbias2"))
        Case "particleamount"
            local6 = scplang_getphrase("tooltips.particleamount")
            Select arg5
                Case 0.0
                    local8 = $FF
                    local7 = scplang_getphrase("tooltips.particleamountsmoke")
                Case 1.0
                    local8 = $FF
                    local9 = $FF
                    local7 = scplang_getphrase("tooltips.particleamountfew")
                Case 2.0
                    local9 = $FF
                    local7 = scplang_getphrase("tooltips.particleamountall")
            End Select
        Case "vram"
            local6 = scplang_getphrase("tooltips.vram")
            local7 = scplang_getphrase("tooltips.notingame")
            local8 = $FF
        Case "musicvol"
            local6 = scplang_getphrase("tooltips.musicvol")
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (((((scplang_getphrase("tooltips.currentval") + " ") + (Str (Int (arg5 * 100.0)))) + "% (") + scplang_getphrase("tooltips.defaultis")) + " 50%)")
        Case "soundvol"
            local6 = scplang_getphrase("tooltips.soundvol")
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (((((scplang_getphrase("tooltips.currentval") + " ") + (Str (Int (arg5 * 100.0)))) + "% (") + scplang_getphrase("tooltips.defaultis")) + " 50%)")
        Case "sfxautorelease"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.soundautorelease")) + chr($22)) + " ") + scplang_getphrase("tooltips.soundautorelease2"))
            local8 = $FF
            local7 = scplang_getphrase("tooltips.notingame")
        Case "usertrack"
            local6 = ((((scplang_getphrase("tooltips.usertrack1") + " ") + chr($22)) + "SFX\Radio\UserTracks") + chr($22))
            local6 = ((((((((local6 + " ") + scplang_getphrase("tooltips.usertrack2")) + " ") + chr($22)) + "1") + chr($22)) + " ") + scplang_getphrase("tooltips.usertrack3"))
            local8 = $FF
            local7 = scplang_getphrase("tooltips.notingame")
        Case "usertrackmode"
            local6 = ((((((((((((scplang_getphrase("tooltips.usertrackmode1") + " ") + chr($22)) + scplang_getphrase("tooltips.usertrackmode2")) + chr($22)) + " ") + scplang_getphrase("tooltips.usertrackmode3")) + " ") + chr($22)) + scplang_getphrase("tooltips.usertrackmode4")) + chr($22)) + " ") + scplang_getphrase("tooltips.usertrackmode5"))
            local8 = $FF
            local9 = $FF
            local7 = scplang_getphrase("tooltips.usertrackmode6")
        Case "usertrackscan"
            local6 = scplang_getphrase("tooltips.usertrackrescan")
        Case "mousesensitivity"
            local6 = scplang_getphrase("tooltips.mousesens")
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (((((scplang_getphrase("tooltips.currentval") + " ") + (Str (Int ((0.5 + arg5) * 100.0)))) + "% (") + scplang_getphrase("tooltips.defaultis")) + " 50%)")
        Case "mouseinvert"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.mouseinvert")) + chr($22)) + " ") + scplang_getphrase("tooltips.selfexplan"))
        Case "mousesmoothing"
            local6 = scplang_getphrase("tooltips.mousesmoothing")
        Case "controls"
            local6 = scplang_getphrase("tooltips.controls")
        Case "hud"
            local6 = scplang_getphrase("tooltips.hud")
        Case "consoleenable"
            local6 = (((scplang_getphrase("tooltips.devconsole") + " ") + keyname(key_console)) + ".")
        Case "consoleerror"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.consoleonerror")) + chr($22)) + " ") + scplang_getphrase("tooltips.selfexplan"))
        Case "achpopup"
            local6 = scplang_getphrase("tooltips.achievements")
        Case "showfps"
            local6 = scplang_getphrase("tooltips.showfps")
        Case "framelimit"
            local6 = scplang_getphrase("tooltips.limitfps")
            If (((0.0 < arg5) And (60.0 > arg5)) <> 0) Then
                local8 = $FF
                local9 = $FF
                local7 = scplang_getphrase("tooltips.limitfps2")
            EndIf
        Case "antialiastext"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.antialiasedtext")) + chr($22)) + " ") + scplang_getphrase("tooltips.antialiasedtext2"))
        Case "thaumiel"
            local6 = scplang_getphrase("tooltips.apollyon")
        Case "consoleversion"
            local6 = scplang_getphrase("tooltips.consoleversion")
        Case "fov"
            local6 = ((((chr($22) + scplang_getphrase("tooltips.fov")) + chr($22)) + " ") + scplang_getphrase("tooltips.fov2"))
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (((((scplang_getphrase("tooltips.currentval") + " ") + (Str (Int fov))) + " (") + scplang_getphrase("tooltips.defaultis")) + " 74%)")
    End Select
    local4 = getlineamount(local6, (Int local2), (Int local3), 1.0)
    If (local11 <> 0) Then
        local12 = (Int (210.0 * menuscale))
    EndIf
    If (local7 = "") Then
        drawframe(arg0, arg1, arg2, (Int ((((Float ($0A + local4)) * menuscale) + (Float (aastringheight(local6) * local4))) + (Float local12))), $00, $00)
    Else
        local5 = getlineamount(local7, (Int local2), (Int local3), 1.0)
        drawframe(arg0, arg1, arg2, (Int ((((((Float ($0A + local4)) * menuscale) + (Float (aastringheight(local6) * local4))) + (Float (aastringheight(local7) * local5))) + ((Float ($0A + local5)) * menuscale)) + (Float local12))), $00, $00)
    EndIf
    rowtext(local6, (Int local0), (Int local1), (Int local2), (Int local3), $00, 1.0)
    If (local7 <> "") Then
        color(local8, local9, local10)
        rowtext(local7, (Int local0), (Int ((local1 + (Float (aastringheight(local6) * local4))) + ((Float ($05 + local4)) * menuscale))), (Int local2), (Int local3), $00, 1.0)
    EndIf
    If (local11 <> 0) Then
        midhandle(menu_testimg)
        If (local7 = "") Then
            drawimage(menu_testimg, ((arg2 Sar $01) + arg0), (Int (((100.0 * menuscale) + (Float arg1)) + (((Float ($0A + local4)) * menuscale) + (Float (aastringheight(local6) * local4))))), $00)
        Else
            drawimage(menu_testimg, ((arg2 Sar $01) + arg0), (Int ((((((Float ($0A + local4)) * menuscale) + (Float (aastringheight(local6) * local4))) + (Float (aastringheight(local7) * local5))) + ((Float ($0A + local5)) * menuscale)) + ((100.0 * menuscale) + (Float arg1)))), $00)
        EndIf
    EndIf
    Return $00
End Function
