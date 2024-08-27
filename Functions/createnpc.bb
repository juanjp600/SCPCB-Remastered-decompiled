Function createnpc.npcs(arg0%, arg1#, arg2#, arg3#)
    Local local0.npcs
    Local local1.npcs
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10.objects
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18.rooms
    Local local20%
    Local local21%
    Local local22%
    local0 = (New npcs)
    local10 = (First objects)
    local0\Field5 = arg0
    local0\Field44 = 1.0
    local0\Field45 = 0.2
    local0\Field70 = 0.2
    local0\Field74 = 10.0
    Select arg0
        Case $08
            local0\Field43 = "SCP-173"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.23, 0.32)
            entitytype(local0\Field4, $02, $00)
            local0\Field8 = $01
            local0\Field0 = copyentity(local10\Field0[$00], $00)
            If (left(currentdate(), $07) = "31 Oct ") Then
                at\Field1[$00] = $01
                local12 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_173_h.pt"), $01)
                entitytexture(local0\Field0, local12, $00, $00)
                freetexture(local12)
            EndIf
            If (left(currentdate(), $07) = "1 Jan ") Then
                at\Field1[$01] = $01
                local13 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_173_ny.pt"), $01)
                entitytexture(local0\Field0, local13, $00, $00)
                freetexture(local13)
            EndIf
            local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-173", "scale", 0.0) / meshdepth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-173", "speed", 0.0) / 100.0)
            local0\Field1 = copyentity(local10\Field0[$22], $00)
            scaleentity(local0\Field1, roomscale, roomscale, roomscale, $00)
            hideentity(local0\Field1)
            local0\Field70 = 0.32
        Case $07
            local0\Field43 = "SCP-106"
            local0\Field4 = createpivot($00)
            local0\Field44 = 0.0
            local0\Field45 = 0.0
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$01], $00)
            local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-106", "scale", 0.0) / 2.2)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local14 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_106_eyes.png"), $01)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-106", "speed", 0.0) / 100.0)
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.03, 0.03)
            entitytexture(local0\Field1, local14, $00, $00)
            entityblend(local0\Field1, $03)
            entityfx(local0\Field1, $09)
            spriteviewmode(local0\Field1, $02)
            freetexture(local14)
        Case $13
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$02], $00)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "Guard", "speed", 0.0) / 100.0)
            local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "Guard", "scale", 0.0) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
        Case $12
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$03], $00)
            local2 = (0.5 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = 0.02
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            local0\Field70 = 0.32
        Case $09
            local0\Field43 = "SCP-372"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = copyentity(local10\Field0[$04], $00)
            local2 = (0.3 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $10
            local0\Field43 = "Apache Helicopter"
            local0\Field44 = 0.0
            local0\Field45 = 0.0
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = copyentity(local10\Field0[$05], $00)
            local0\Field1 = copyentity(local10\Field0[$06], $00)
            entityparent(local0\Field1, local0\Field0, $01)
            For local3 = $FFFFFFFF To $01 Step $02
                local15 = copyentity(local0\Field1, local0\Field1)
                rotateentity(local15, 0.0, (4.0 * (Float local3)), 0.0, $00)
                entityalpha(local15, 0.5)
            Next
            local0\Field2 = copyentity(local10\Field0[$1A], $00)
            entityparent(local0\Field2, local0\Field0, $01)
            positionentity(local0\Field2, 0.0, 2.15, -5.48, $00)
            entitytype(local0\Field4, $04, $00)
            entityradius(local0\Field4, 3.0, 0.0)
            For local3 = $FFFFFFFF To $01 Step $02
                local16 = createlight($02, local0\Field0)
                lightrange(local16, 2.0)
                lightcolor(local16, 255.0, 255.0, 255.0)
                positionentity(local16, (1.65 * (Float local3)), 1.17, -0.25, $00)
                local17 = createsprite(local0\Field0)
                positionentity(local17, (1.65 * (Float local3)), 1.17, 0.0, $00)
                scalesprite(local17, 0.13, 0.13)
                entitytexture(local17, at\Field3[$00], $00, $00)
                entityblend(local17, $03)
                entityfx(local17, $09)
            Next
            local2 = 0.7
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $14
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$07], $00)
                local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "MTF", "scale", 0.0) / 2.5)
                scaleentity(local0\Field0, local2, local2, local2, $00)
                meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            EndIf
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "MTF", "speed", 0.0) / 100.0)
            If (mtfsfx($00) = $00) Then
                mtfsfx($00) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\ClassD1.ogg"))
                mtfsfx($01) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\ClassD2.ogg"))
                mtfsfx($02) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\ClassD3.ogg"))
                mtfsfx($03) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\ClassD4.ogg"))
                mtfsfx($05) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\Beep.ogg"))
                mtfsfx($06) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\Breath.ogg"))
            EndIf
            If (mtfrooms[$06] = Null) Then
                For local18 = Each rooms
                    Select lower(local18\Field7\Field10)
                        Case "room106"
                            mtfrooms[$00] = local18
                        Case "room372"
                            mtfrooms[$01] = local18
                        Case "room079"
                            mtfrooms[$02] = local18
                        Case "room2poffices"
                            mtfrooms[$03] = local18
                        Case "room914"
                            mtfrooms[$04] = local18
                        Case "room895"
                            mtfrooms[$05] = local18
                        Case "room173"
                            mtfrooms[$06] = local18
                    End Select
                Next
            EndIf
        Case $06
            local0\Field43 = "SCP-096"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.26, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$08], $00)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-096", "speed", 0.0) / 100.0)
            local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-096", "scale", 0.0) / 3.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, ((- meshwidth(local0\Field0)) * 2.0), ((- meshheight(local0\Field0)) * 2.0), ((- meshdepth(local0\Field0)) * 2.0), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 4.0), (meshdepth(local0\Field0) * 4.0))
            local0\Field70 = 0.26
        Case $03
            local0\Field43 = "SCP-049"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$09], $00)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("DATA\NPCs.ini"), "SCP-049", "speed", 0.0) / 100.0)
            local2 = getinifloat(scpmodding_processfilepath("DATA\NPCs.ini"), "SCP-049", "scale", 0.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Horror\Horror12.ogg"))
            If (horrorsfx($0D) = $00) Then
                horrorsfx($0D) = loadsound_strict(scpmodding_processfilepath("SFX\Horror\Horror13.ogg"))
            EndIf
            local0\Field59 = $01
        Case $04
            local0\Field43 = "SCP-049-2"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$0A], $00)
                local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-049-2", "scale", 0.0) / 2.5)
                scaleentity(local0\Field0, local2, local2, local2, $00)
                meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            EndIf
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-049-2", "speed", 0.0) / 100.0)
            setanimtime(local0\Field0, 107.0, $00)
            local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\049_2\Breath.ogg"))
            local0\Field61 = $64
        Case $0A
            local0\Field43 = "SCP-513-1"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = copyentity(local10\Field0[$0B], $00)
            local0\Field1 = copyentity(local0\Field0, $00)
            entityalpha(local0\Field1, 0.6)
            local2 = (1.8 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            scaleentity(local0\Field1, local2, local2, local2, $00)
        Case $02
            local0\Field43 = "Unidentified"
            local0\Field4 = createpivot($00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$0C], $00)
                scaleentity(local0\Field0, 0.065, 0.065, 0.065, $00)
            EndIf
            setanimtime(local0\Field0, 283.0, $00)
            local0\Field61 = $96
        Case $0B
            local0\Field43 = "Unidentified"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.25, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$0D], $00)
            entityfx(local0\Field0, $01)
            local20 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_860_2_eyes.png"), $03)
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.1, 0.1)
            entitytexture(local0\Field1, local20, $00, $00)
            freetexture(local20)
            entityfx(local0\Field1, $09)
            entityblend(local0\Field1, local21)
            spriteviewmode(local0\Field1, $02)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-860-2", "speed", 0.0) / 100.0)
            local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-860-2", "scale", 0.0) / 20.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            meshcullbox(local0\Field0, ((- meshwidth(local0\Field0)) * 2.0), ((- meshheight(local0\Field0)) * 2.0), ((- meshdepth(local0\Field0)) * 2.0), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 4.0), (meshdepth(local0\Field0) * 4.0))
            local0\Field70 = 0.25
        Case $0C
            local22 = $00
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local22 = (local22 + $01)
                EndIf
            Next
            If (local22 = $00) Then
                local3 = $35
            EndIf
            If (local22 = $01) Then
                local3 = $59
            EndIf
            If (local22 = $02) Then
                local3 = $60
            EndIf
            If (local22 = $03) Then
                local3 = $18
            EndIf
            local0\Field43 = ("SCP-939-" + (Str local3))
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.3, 0.0)
            entitytype(local0\Field4, $02, $00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$0E], $00)
                local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-939", "scale", 0.0) / 2.5)
                scaleentity(local0\Field0, local2, local2, local2, $00)
            EndIf
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-939", "speed", 0.0) / 100.0)
            local0\Field70 = 0.3
        Case $05
            local0\Field43 = "SCP-066"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$0F], $00)
            local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-066", "scale", 0.0) / 2.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-066", "speed", 0.0) / 100.0)
        Case $0D
            local3 = $01
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local3 = (local3 + $01)
                EndIf
            Next
            local0\Field43 = ("SCP-966-" + (Str local3))
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$10], $00)
                entityfx(local0\Field0, $01)
                local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-966", "scale", 0.0) / 40.0)
                scaleentity(local0\Field0, local2, local2, local2, $00)
            EndIf
            setanimtime(local0\Field0, 15.0, $00)
            entitytype(local0\Field4, $02, $00)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-966", "speed", 0.0) / 100.0)
        Case $0E
            local0\Field43 = "SCP-1048-A"
            local0\Field0 = copyentity(local10\Field0[$11], $00)
            scaleentity(local0\Field0, 0.05, 0.05, 0.05, $00)
            setanimtime(local0\Field0, 2.0, $00)
            local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1048A\Shriek.ogg"))
            local0\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1048A\Growth.ogg"))
        Case $0F
            local0\Field43 = "Unidentified"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$12], $00)
            EndIf
            local0\Field21 = ((getinifloat(scpmodding_processfilepath("DATA\NPCs.ini"), "SCP-1499-1", "speed", 0.0) / 100.0) * rnd(0.9, 1.1))
            local2 = ((getinifloat(scpmodding_processfilepath("DATA\NPCs.ini"), "SCP-1499-1", "scale", 0.0) / 4.0) * rnd(0.8, 1.0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            entityfx(local0\Field0, $01)
            entityautofade(local0\Field0, (hidedistance * 2.5), (hidedistance * 2.95))
        Case $01
            local0\Field43 = "SCP-008-1"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$13], $00)
            local2 = (0.5 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = 0.02
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            setnpcframe(local0, 11.0)
            local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\008_1\Breath.ogg"))
            local0\Field61 = $78
        Case $11
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = copyentity(local10\Field0[$14], $00)
            local2 = (0.5 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = 0.02
            meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            local0\Field70 = 0.32
        Case $16
            local0\Field43 = "SCP-008-2"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$15], $00)
                local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-008-2", "scale", 0.0) / 2.5)
                scaleentity(local0\Field0, local2, local2, local2, $00)
                meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            EndIf
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-008-2", "speed", 0.0) / 100.0)
            setanimtime(local0\Field0, 107.0, $00)
            local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\008_1\Breath.ogg"))
            local0\Field61 = $78
        Case $1A
            local0\Field43 = "SCP-650"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.23, 0.32)
            entitytype(local0\Field4, $02, $00)
            local0\Field8 = $01
            local0\Field0 = copyentity(local10\Field0[$16], $00)
            local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-650", "scale", 0.0) / meshdepth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-650", "speed", 0.0) / 100.0)
            setnpcframe(local0, 1.0)
            local0\Field70 = 0.5
        Case $19
            local0\Field43 = "SCP-457"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$01], $00)
                local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-457", "scale", 0.0) / 2.2)
                scaleentity(local0\Field0, local2, local2, local2, $00)
            EndIf
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-457", "speed", 0.0) / 150.0)
            local20 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_457.png"), $01)
            entityalpha(local0\Field0, 0.25)
            entitytexture(local0\Field0, local20, $00, $00)
            freetexture(local20)
            local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\457\Sighting.ogg"))
            local0\Field70 = 0.32
        Case $17
            local0\Field43 = "SCP-049-3"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$17], $00)
                meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
                local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-049-3", "scale", 0.0) / 20.6)
                scaleentity(local0\Field0, local2, local2, local2, $00)
            EndIf
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-049-3", "speed", 0.0) / 100.0)
            setanimtime(local0\Field0, 3.0, $00)
            local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\049_2\Breath.ogg"))
            local0\Field61 = $64
        Case $18
            local0\Field43 = "Unidentified"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$18], $00)
                local2 = rnd(0.09, 0.125)
                entityfx(local0\Field0, $01)
                local2 = (rnd(0.47, 0.67) / meshwidth(local0\Field0))
                scaleentity(local0\Field0, local2, local2, local2, $00)
            EndIf
            setanimtime(local0\Field0, 15.0, $00)
            entitytype(local0\Field4, $05, $00)
            local0\Field21 = 0.02
        Case $1C
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$19], $00)
                local2 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "MTF2", "scale", 0.0) / 2.5)
                scaleentity(local0\Field0, local2, local2, local2, $00)
                meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            EndIf
            local0\Field21 = (getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "MTF2", "speed", 0.0) / 100.0)
            If (mtf2sfx($00) = $00) Then
                mtf2sfx($00) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF2\Stop1.ogg"))
                mtf2sfx($01) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF2\Stop2.ogg"))
                mtf2sfx($02) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF2\Stop3.ogg"))
                mtf2sfx($03) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF2\ClassD2.ogg"))
                mtf2sfx($04) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF2\ClassD1.ogg"))
                mtf2sfx($05) = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF2\Beep.ogg"))
            EndIf
            If (mtf2rooms[$06] = Null) Then
                For local18 = Each rooms
                    Select lower(local18\Field7\Field10)
                        Case "room895"
                            mtf2rooms[$00] = local18
                        Case "room005"
                            mtf2rooms[$01] = local18
                        Case "room1office"
                            mtf2rooms[$02] = local18
                        Case "room2poffices"
                            mtf2rooms[$03] = local18
                        Case "room914"
                            mtf2rooms[$04] = local18
                        Case "room650"
                            mtf2rooms[$05] = local18
                        Case "room173"
                            mtf2rooms[$06] = local18
                    End Select
                Next
            EndIf
        Case $1B
            local0\Field43 = "Human"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            For local1 = Each npcs
                If (((local0\Field5 = local1\Field5) And (local0 <> local1)) <> 0) Then
                    local0\Field0 = copyentity(local1\Field0, $00)
                    Exit
                EndIf
            Next
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$1F], $00)
                local2 = (0.55 / meshwidth(local0\Field0))
                scaleentity(local0\Field0, local2, local2, local2, $00)
                meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            EndIf
            local0\Field21 = 0.02
            local0\Field70 = 0.32
        Case $1D
            local0\Field43 = "Vehicle"
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            If (local0\Field0 = $00) Then
                local0\Field0 = copyentity(local10\Field0[$27], $00)
                local2 = (1.86 / meshwidth(local0\Field0))
                scaleentity(local0\Field0, local2, local2, local2, $00)
                meshcullbox(local0\Field0, (- meshwidth(local0\Field0)), (- meshheight(local0\Field0)), (- meshdepth(local0\Field0)), (meshwidth(local0\Field0) * 2.0), (meshheight(local0\Field0) * 2.0), (meshdepth(local0\Field0) * 2.0))
            EndIf
            local0\Field21 = 0.02
            local0\Field70 = 0.72
    End Select
    positionentity(local0\Field4, arg1, arg2, arg3, $01)
    positionentity(local0\Field0, arg1, arg2, arg3, $01)
    resetentity(local0\Field4)
    local0\Field6 = $00
    local0\Field6 = findfreenpcid()
    npcspeedchange(local0)
    Return local0
    Return Null
End Function
