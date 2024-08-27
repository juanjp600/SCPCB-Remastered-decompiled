Function update008%()
    Local local0%
    Local local1.rooms
    Local local2%
    Local local3#
    Local local4.fps_settings
    Local local5.events
    Local local6.decals
    Local local7.particles
    local2 = $01
    local3 = i_008\Field0
    local4 = (First fps_settings)
    If (playerroom\Field7\Field10 = "room860") Then
        For local5 = Each events
            If (local5\Field0 = "room860") Then
                If (1.0 = local5\Field2) Then
                    local2 = $00
                EndIf
                Exit
            EndIf
        Next
    ElseIf ((((playerroom\Field7\Field10 = "dimension1499") Or (playerroom\Field7\Field10 = "pocketdimension")) Or (playerroom\Field7\Field10 = "gatea")) <> 0) Then
        local2 = $00
    ElseIf (((playerroom\Field7\Field10 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
        local2 = $00
    EndIf
    If (0.0 < i_008\Field0) Then
        showentity(at\Field4[$02])
        For local0 = $00 To $06 Step $01
            If (i_008\Field2[local0] = $00) Then
                i_008\Field2[local0] = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\008\Voices" + (Str local0)) + ".ogg")))
            EndIf
        Next
        For local0 = $00 To $01 Step $01
            If (i_008\Field3[local0] = $00) Then
                i_008\Field3[local0] = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\008\KillScientist" + (Str local0)) + ".ogg")))
            EndIf
        Next
        If (93.0 > i_008\Field0) Then
            If ((i_427\Field0 And (25200.0 > i_427\Field1)) = $00) Then
                i_008\Field0 = min((i_008\Field0 + (local4\Field3[$00] * 0.002)), 100.0)
            EndIf
            blurtimer = max(((i_008\Field0 * 3.0) * (2.0 - crouchstate)), blurtimer)
            heartbeatrate = max(heartbeatrate, 100.0)
            heartbeatvolume = max(heartbeatvolume, (i_008\Field0 / 120.0))
            entityalpha(at\Field4[$02], (min((((i_008\Field0 * 0.2) ^ 2.0) / 1000.0), 0.5) * (sin(((Float millisecs2()) / 8.0)) + 2.0)))
            For local0 = $00 To $06 Step $01
                If ((((Float ((local0 * $0F) + $0A)) < i_008\Field0) And ((Float ((local0 * $0F) + $0A)) >= local3)) <> 0) Then
                    playsound_strict(i_008\Field2[rand($00, $06)])
                EndIf
            Next
            If (((20.0 < i_008\Field0) And (20.0 >= local3)) <> 0) Then
                msg = scplang_getphrase("ingame.scp0081")
                msgtimer = 420.0
            ElseIf (((40.0 < i_008\Field0) And (40.0 >= local3)) <> 0) Then
                msg = scplang_getphrase("ingame.scp0082")
                msgtimer = 420.0
            ElseIf (((60.0 < i_008\Field0) And (60.0 >= local3)) <> 0) Then
                msg = scplang_getphrase("ingame.scp0083")
                msgtimer = 420.0
            ElseIf (((80.0 < i_008\Field0) And (80.0 >= local3)) <> 0) Then
                msg = scplang_getphrase("ingame.scp0084")
                msgtimer = 420.0
            ElseIf (91.5 <= i_008\Field0) Then
                blinktimer = max(min(((i_008\Field0 - 91.5) * -10.0), blinktimer), -10.0)
                i_008\Field1 = $01
                unabletomove = $01
                If (((92.7 <= i_008\Field0) And (92.7 > local3)) <> 0) Then
                    If (local2 <> 0) Then
                        For local1 = Each rooms
                            If (local1\Field7\Field10 = "room008") Then
                                positionentity(collider, entityx(local1\Field19[$07], $01), entityy(local1\Field19[$07], $01), entityz(local1\Field19[$07], $01), $01)
                                resetentity(collider)
                                local1\Field22[$00] = createnpc($12, entityx(local1\Field19[$06], $01), (entityy(local1\Field19[$06], $01) + 0.2), entityz(local1\Field19[$06], $01))
                                local1\Field22[$00]\Field17 = playsound_strict(i_008\Field3[$00])
                                changenpctextureid(local1\Field22[$00], $10)
                                local1\Field22[$00]\Field9 = 6.0
                                playerroom = local1
                                unabletomove = $00
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
            EndIf
        Else
            i_008\Field0 = min((i_008\Field0 + (local4\Field3[$00] * 0.004)), 100.0)
            If (local2 <> 0) Then
                If (94.7 > i_008\Field0) Then
                    entityalpha(at\Field4[$02], ((sin(((Float millisecs2()) / 8.0)) + 2.0) * 0.5))
                    blurtimer = 900.0
                    If (94.5 < i_008\Field0) Then
                        blinktimer = max(min(((i_008\Field0 - 94.5) * -50.0), blinktimer), -10.0)
                    EndIf
                    pointentity(collider, playerroom\Field22[$00]\Field4, 0.0)
                    pointentity(playerroom\Field22[$00]\Field4, collider, 0.0)
                    pointentity(camera, playerroom\Field22[$00]\Field4, entityroll(camera, $00))
                    forcemove = 0.75
                    injuries = 2.5
                    bloodloss = 0.0
                    i_1079\Field0 = 0.0
                    i_1079\Field1 = $00
                    unabletomove = $00
                    animate2(playerroom\Field22[$00]\Field0, animtime(playerroom\Field22[$00]\Field0), $165, $17D, 0.3, $01)
                ElseIf (98.5 > i_008\Field0) Then
                    entityalpha(at\Field4[$02], ((sin(((Float millisecs2()) / 5.0)) + 2.0) * 0.5))
                    blurtimer = 950.0
                    forcemove = 0.0
                    unabletomove = $01
                    pointentity(camera, playerroom\Field22[$00]\Field4, 0.0)
                    If (94.7 > local3) Then
                        playerroom\Field22[$00]\Field17 = playsound_strict(i_008\Field3[$01])
                        deathmsg = scplang_getphrase("ingame.scp0085")
                        kill($00, $00)
                        local6 = createdecal($03, entityx(playerroom\Field22[$00]\Field4, $00), ((544.0 * roomscale) + 0.01), entityz(playerroom\Field22[$00]\Field4, $00), 90.0, rnd(360.0, 0.0), 0.0)
                        local6\Field2 = 0.8
                        scalesprite(local6\Field0, local6\Field2, local6\Field2)
                    ElseIf (96.0 < i_008\Field0) Then
                        blinktimer = max(min(((i_008\Field0 - 96.0) * -10.0), blinktimer), -10.0)
                    Else
                        killtimer = max(-350.0, killtimer)
                    EndIf
                    If (0.0 = playerroom\Field22[$00]\Field10) Then
                        animate2(playerroom\Field22[$00]\Field0, animtime(playerroom\Field22[$00]\Field0), $0D, $13, 0.3, $00)
                        If (19.0 <= animtime(playerroom\Field22[$00]\Field0)) Then
                            playerroom\Field22[$00]\Field10 = 1.0
                        EndIf
                    Else
                        animate2(playerroom\Field22[$00]\Field0, animtime(playerroom\Field22[$00]\Field0), $13, $0D, -0.3, $01)
                        If (13.0 >= animtime(playerroom\Field22[$00]\Field0)) Then
                            playerroom\Field22[$00]\Field10 = 0.0
                        EndIf
                    EndIf
                    If (particleamount > $00) Then
                        If (rand($32, $01) = $01) Then
                            local7 = createparticle(entityx(playerroom\Field22[$00]\Field4, $00), entityy(playerroom\Field22[$00]\Field4, $00), entityz(playerroom\Field22[$00]\Field4, $00), $05, rnd(0.05, 0.1), 0.15, $C8)
                            local7\Field8 = 0.01
                            local7\Field15 = 0.01
                            local7\Field6 = 0.5
                            local7\Field14 = -0.01
                            rotateentity(local7\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                        EndIf
                    EndIf
                    positionentity(head, entityx(playerroom\Field22[$00]\Field4, $01), (entityy(playerroom\Field22[$00]\Field4, $01) + 0.65), entityz(playerroom\Field22[$00]\Field4, $01), $01)
                    rotateentity(head, ((sin(((Float millisecs2()) / 5.0)) + 1.0) * 15.0), (Float (playerroom\Field6 - $B4)), 0.0, $01)
                    moveentity(head, 0.0, 0.0, -0.4)
                    turnentity(head, ((sin(((Float millisecs2()) / 5.0)) * 30.0) + 80.0), (sin(((Float millisecs2()) / 5.0)) * 40.0), 0.0, $00)
                EndIf
            Else
                kill($00, $00)
                blinktimer = max(min(((i_008\Field0 - 96.0) * -10.0), blinktimer), -10.0)
                If (playerroom\Field7\Field10 = "dimension1499") Then
                    deathmsg = scplang_getphrase("ingame.scp0086")
                ElseIf (((playerroom\Field7\Field10 = "gatea") Or (playerroom\Field7\Field10 = "gateb")) <> 0) Then
                    deathmsg = (("Subject D-9341 " + scplang_getphrase("ingame.scp0087")) + " ")
                    If (playerroom\Field7\Field10 = "gatea") Then
                        deathmsg = (deathmsg + "A")
                    Else
                        deathmsg = (deathmsg + "B")
                    EndIf
                    deathmsg = (deathmsg + scplang_getphrase("ingame.scp0088"))
                Else
                    deathmsg = ""
                EndIf
            EndIf
        EndIf
    Else
        hideentity(at\Field4[$02])
    EndIf
    Return $00
End Function
