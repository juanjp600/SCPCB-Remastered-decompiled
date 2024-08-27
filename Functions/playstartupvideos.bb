Function playstartupvideos%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4#
    Local local5%
    Local local6$
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    local0 = createcamera($00)
    cameraclsmode(local0, $00, $01)
    local1 = createquad()
    local2 = createtexture($800, $800, $130, $01)
    entitytexture(local1, local2, $00, $00)
    entityfx(local1, $01)
    camerarange(local0, 0.01, 100.0)
    translateentity(local0, (1.0 / 2048.0), (1.0 / -2048.0), -1.0, $00)
    entityparent(local1, local0, $01)
    local4 = ((Float realgraphicwidth) / (Float realgraphicheight))
    If (((1.76 < local4) And (1.78 > local4)) <> 0) Then
        local3 = realgraphicheight
    Else
        local3 = (Int ((Float realgraphicwidth) / (1.0 / 0.5625)))
    EndIf
    For local5 = $00 To $02 Step $01
        Select local5
            Case $00
                local6 = scpmodding_processfilepath("GFX\menu\startup_RM")
            Case $01
                local6 = scpmodding_processfilepath("GFX\menu\startup_TSS")
            Case $02
                local6 = scpmodding_processfilepath("GFX\menu\startup_Undertow")
        End Select
        blitzmovie_open((local6 + ".wmv"))
        local8 = blitzmovie_getwidth()
        local9 = blitzmovie_getheight()
        blitzmovie_close()
        local10 = createimage(local8, local9, $01)
        local11 = blitzmovie_opendecodetoimage((local6 + ".wmv"), local10, $00)
        If (local11 = $00) Then
            freetexture(local2)
            freeentity(local1)
            freeentity(local0)
            freeimage(local10)
            putinivalue("options.ini", "options", "play startup video", "false")
            Return $00
        EndIf
        local11 = blitzmovie_play()
        local12 = streamsound_strict((local6 + ".ogg"), sfxvolume, $00)
        Repeat
            cls()
            projectimage(local10, (Float realgraphicwidth), (Float local3), local1, local2)
            color($FF, $FF, $FF)
            text((graphicwidth Sar $01), (graphicheight - $32), scplang_getphrase("loadingscreens.anykey2"), $01, $01)
            flip($01)
        Until ((getkey() Or (isstreamplaying_strict(local12) = $00)) <> 0)
        stopstream_strict(local12)
        blitzmovie_stop()
        blitzmovie_close()
        freeimage(local10)
        cls()
        flip($01)
    Next
    freetexture(local2)
    freeentity(local1)
    freeentity(local0)
    Return $00
End Function
