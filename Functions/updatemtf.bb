Function updatemtf%()
    Local local0.rooms
    Local local1.npcs
    Local local2%
    Local local3%
    Local local4.fps_settings
    Local local5.rooms
    Local local6.npcs
    If (((((playerroom\Field7\Field10 = "gateaentrance") Or (playerroom\Field7\Field10 = "gateb")) Or (playerroom\Field7\Field10 = "room106")) Or (playerroom\Field7\Field10 = "room457")) <> 0) Then
        Return $00
    EndIf
    local4 = (First fps_settings)
    If (0.0 = mtftimer) Then
        If (((rand($1E, $01) = $01) And (playerroom\Field7\Field10 <> "dimension1499")) <> 0) Then
            local5 = Null
            For local0 = Each rooms
                If (lower(local0\Field7\Field10) = "gateaentrance") Then
                    local5 = local0
                    Exit
                EndIf
            Next
            If (local5 <> Null) Then
                If (30.0 > (Abs (entityz(local5\Field2, $00) - entityz(collider, $00)))) Then
                    If (playerinreachableroom($00) <> 0) Then
                        playannouncement(scpmodding_processfilepath("SFX\Character\MTF\Announc.ogg"))
                        giveachievement($37, $01)
                    EndIf
                    mtftimer = local4\Field3[$00]
                    For local3 = $00 To $02 Step $01
                        local1 = createnpc($14, (entityx(local5\Field2, $00) + (0.3 * (Float (local3 - $01)))), 1.0, (entityz(local5\Field2, $00) + 8.0))
                        If (local3 = $00) Then
                            local6 = local1
                        Else
                            local1\Field47 = local6
                        EndIf
                        local1\Field28 = (Float local3)
                    Next
                EndIf
            EndIf
        EndIf
    ElseIf (6300.0 >= mtftimer) Then
        mtftimer = (local4\Field3[$00] + mtftimer)
    ElseIf (((6300.0 < mtftimer) And (6370.0 > mtftimer)) <> 0) Then
        If (playerinreachableroom($00) <> 0) Then
            playannouncement(scpmodding_processfilepath("SFX\Character\MTF2\Announc.ogg"))
        EndIf
        mtftimer = 6370.0
    ElseIf (((6370.0 <= mtftimer) And (9170.0 >= mtftimer)) <> 0) Then
        mtftimer = (local4\Field3[$00] + mtftimer)
    ElseIf (((9170.0 < mtftimer) And (10000.0 > mtftimer)) <> 0) Then
        If (playerinreachableroom($00) <> 0) Then
            playannouncement(scpmodding_processfilepath("SFX\Character\MTF\AnnouncAfter1.ogg"))
        EndIf
        mtftimer = 10000.0
    ElseIf (((10000.0 <= mtftimer) And (18400.0 >= mtftimer)) <> 0) Then
        mtftimer = (local4\Field3[$00] + mtftimer)
    ElseIf (((18400.0 < mtftimer) And (20000.0 > mtftimer)) <> 0) Then
        If (playerinreachableroom($00) <> 0) Then
            playannouncement(scpmodding_processfilepath("SFX\Character\MTF\AnnouncAfter2.ogg"))
        EndIf
        mtftimer = 20000.0
    ElseIf (((20000.0 <= mtftimer) And (24200.0 >= mtftimer)) <> 0) Then
        mtftimer = (local4\Field3[$00] + mtftimer)
    ElseIf (((24200.0 < mtftimer) And (25000.0 > mtftimer)) <> 0) Then
        If (playerinreachableroom($00) <> 0) Then
            For local3 = $00 To (maxitemamount - $01) Step $01
                If (inventory(local3) <> Null) Then
                    If (((((((left(inventory(local3)\Field3\Field0, $04) = "SCP-") And (left(inventory(local3)\Field3\Field0, $07) <> "SCP-035")) And (left(inventory(local3)\Field3\Field0, $07) <> "SCP-093")) And (left(inventory(local3)\Field3\Field0, $07) <> "SCP-085")) And (left(inventory(local3)\Field3\Field0, $07) <> "SCP-457")) And (left(inventory(local3)\Field3\Field0, $07) <> "SCP-3651")) <> 0) Then
                        playannouncement(scpmodding_processfilepath("SFX\Character\MTF\ThreatAnnouncPossession.ogg"))
                        mtftimer = 25000.0
                        Return $00
                        Exit
                    EndIf
                EndIf
            Next
            playannouncement(scpmodding_processfilepath((("SFX\Character\MTF\ThreatAnnounc" + (Str rand($01, $03))) + ".ogg")))
        EndIf
        mtftimer = 25000.0
    ElseIf (((25000.0 <= mtftimer) And (29200.0 >= mtftimer)) <> 0) Then
        mtftimer = (local4\Field3[$00] + mtftimer)
    ElseIf (((29200.0 < mtftimer) And (30000.0 > mtftimer)) <> 0) Then
        If (playerinreachableroom($00) <> 0) Then
            playannouncement(scpmodding_processfilepath("SFX\Character\MTF\ThreatAnnouncFinal.ogg"))
        EndIf
        mtftimer = 30000.0
    EndIf
    Return $00
End Function
