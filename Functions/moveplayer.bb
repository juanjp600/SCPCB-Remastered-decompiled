Function moveplayer%()
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    Local local4.fps_settings
    Local local5#
    Local local6%
    Local local7%
    Local local8#
    Local local9%
    Local local10%
    Local local11%
    Local local12.decals
    local0 = 1.0
    local1 = 0.018
    local4 = (First fps_settings)
    If (superman <> 0) Then
        local1 = (local1 * 3.0)
        supermantimer = (local4\Field3[$00] + supermantimer)
        camerashake = (sin((supermantimer / 5.0)) * (supermantimer / 1500.0))
        If (3500.0 < supermantimer) Then
            deathmsg = scplang_getphrase("ingame.superdeath")
            kill($01, $00)
            showentity(at\Field4[$00])
        Else
            blurtimer = 500.0
            hideentity(at\Field4[$00])
        EndIf
    EndIf
    If (0.0 < deathtimer) Then
        deathtimer = (deathtimer - local4\Field3[$00])
        If (1.0 > deathtimer) Then
            deathtimer = -1.0
        EndIf
    ElseIf (0.0 > deathtimer) Then
        kill($01, $00)
    EndIf
    If (0.0 < currspeed) Then
        stamina = min((((local4\Field3[$00] * 0.15) / 1.25) + stamina), 100.0)
    Else
        stamina = min((((local4\Field3[$00] * 0.15) * 1.25) + stamina), 100.0)
    EndIf
    If (0.0 < staminaeffecttimer) Then
        staminaeffecttimer = (staminaeffecttimer - (local4\Field3[$00] / 70.0))
    ElseIf (1.0 <> staminaeffect) Then
        staminaeffect = 1.0
    EndIf
    If (playerroom\Field7\Field10 <> "pocketdimension") Then
        If (keydown(key_sprint) <> 0) Then
            If (5.0 > stamina) Then
                local5 = 0.0
                If (((wearinggasmask > $00) Or (i_1499\Field0 > $00)) <> 0) Then
                    local5 = 1.0
                EndIf
                If (channelplaying(breathchn) = $00) Then
                    breathchn = playsound_strict(breathsfx((Int local5), $00))
                EndIf
            ElseIf (50.0 > stamina) Then
                If (breathchn = $00) Then
                    local5 = 0.0
                    If (((wearinggasmask > $00) Or (i_1499\Field0 > $00)) <> 0) Then
                        local5 = 1.0
                    EndIf
                    breathchn = playsound_strict(breathsfx((Int local5), rand($01, $03)))
                    channelvolume(breathchn, (min(((70.0 - stamina) / 70.0), 1.0) * sfxvolume))
                ElseIf (channelplaying(breathchn) = $00) Then
                    local5 = 0.0
                    If (((wearinggasmask > $00) Or (i_1499\Field0 > $00)) <> 0) Then
                        local5 = 1.0
                    EndIf
                    breathchn = playsound_strict(breathsfx((Int local5), rand($01, $03)))
                    channelvolume(breathchn, (min(((70.0 - stamina) / 70.0), 1.0) * sfxvolume))
                EndIf
            EndIf
        EndIf
    EndIf
    For local2 = $00 To (maxitemamount - $01) Step $01
        If (inventory(local2) <> Null) Then
            If (inventory(local2)\Field3\Field1 = "finevest") Then
                stamina = min(stamina, 60.0)
            EndIf
        EndIf
    Next
    If (i_714\Field0 <> 0) Then
        stamina = min(stamina, 10.0)
        sanity = max(-850.0, sanity)
    EndIf
    If (10.0 < i_409\Field0) Then
        local6 = (Int (i_409\Field0 / 15.0))
        stamina = max(stamina, (Float local6))
    EndIf
    If (0.0 < i_447\Field5) Then
        i_447\Field5 = (i_447\Field5 - local4\Field3[$00])
        If (1.0 > i_447\Field5) Then
            i_447\Field5 = -1.0
        EndIf
    ElseIf (0.0 > i_447\Field5) Then
        i_447\Field4 = $00
    EndIf
    If (0.0 < i_447\Field3) Then
        i_447\Field3 = (i_447\Field3 - local4\Field3[$00])
        If (1.0 > i_447\Field3) Then
            i_447\Field3 = -1.0
        EndIf
    ElseIf (0.0 > i_447\Field3) Then
        i_447\Field2 = $00
    EndIf
    If (0.0 < i_447\Field1) Then
        i_447\Field1 = (i_447\Field1 - local4\Field3[$00])
        If (1.0 > i_447\Field1) Then
            i_447\Field1 = -1.0
        EndIf
    ElseIf (0.0 > i_447\Field1) Then
        i_447\Field0 = $00
    EndIf
    If (i_447\Field0 = $01) Then
        showentity(at\Field4[$07])
    Else
        hideentity(at\Field4[$07])
    EndIf
    If ((((i_447\Field0 = $01) Or (i_447\Field2 = $01)) Or (i_447\Field4 = $01)) <> 0) Then
        deathmsg = scplang_getphrase("ingame.scp447death")
    EndIf
    If (injuries > (4.0 - morphinehealamount)) Then
        kill($00, $00)
    EndIf
    If (0.0 < morphinetimer) Then
        morphinetimer = (morphinetimer - local4\Field3[$00])
        If (1.0 > morphinetimer) Then
            morphinetimer = -1.0
        EndIf
    ElseIf (0.0 > morphinetimer) Then
        If (0.0 < injuries) Then
            injuries = (injuries + morphinehealamount)
        EndIf
        usedmorphine = $00
        morphinehealamount = 0.0
    EndIf
    If (injuries > (4.0 - morphinehealamount)) Then
        kill($00, $00)
    EndIf
    If (i_008\Field1 <> 0) Then
        crouch = $00
    EndIf
    If (0.001 > (Abs (crouchstate - (Float crouch)))) Then
        crouchstate = (Float crouch)
    Else
        crouchstate = curvevalue((Float crouch), crouchstate, 10.0)
    EndIf
    If (chs\Field1 = $00) Then
        If (((((keydown(key_down) Or keydown(key_up)) Or (keydown(key_right) Or keydown(key_left))) And playable) Or (0.0 < forcemove)) <> 0) Then
            If (((((crouch = $00) And keydown(key_sprint)) And (0.0 < stamina)) And (i_008\Field1 = $00)) <> 0) Then
                local0 = 2.5
                stamina = (stamina - ((local4\Field3[$00] * 0.4) * staminaeffect))
                If (0.0 >= stamina) Then
                    stamina = -20.0
                EndIf
            EndIf
            If (playerroom\Field7\Field10 = "pocketdimension") Then
                If ((((2000.0 * roomscale) > entityy(collider, $00)) Or ((2608.0 * roomscale) < entityy(collider, $00))) <> 0) Then
                    stamina = 0.0
                    local1 = 0.015
                    local0 = 1.0
                EndIf
            EndIf
            If (0.0 < forcemove) Then
                local1 = (local1 * forcemove)
            EndIf
            If (selecteditem <> Null) Then
                If (((((((selecteditem\Field3\Field1 = "firstaid") Or (selecteditem\Field3\Field1 = "finefirstaid")) Or (selecteditem\Field3\Field1 = "firstaid2")) Or (selecteditem\Field3\Field1 = "mintfirstaid")) Or (selecteditem\Field3\Field1 = "mintfirstaid2")) Or (selecteditem\Field3\Field1 = "mintfinefirstaid")) <> 0) Then
                    local0 = 0.0
                EndIf
            EndIf
            local5 = (shake Mod 360.0)
            If (unabletomove = $00) Then
                shake = ((((local4\Field3[$00] * min(local0, 1.5)) * 7.0) + shake) Mod 720.0)
            EndIf
            If ((((180.0 > local5) And (180.0 <= (shake Mod 360.0))) And (0.0 <= killtimer)) <> 0) Then
                If (currstepsfx = $00) Then
                    local5 = (Float getstepsound(collider))
                    If (1.0 = local0) Then
                        playersoundvolume = max(4.0, playersoundvolume)
                        local7 = playsound_strict(stepsfx((Int local5), $00, rand($00, $07)))
                        channelvolume(local7, ((1.0 - ((Float crouch) * 0.6)) * sfxvolume))
                    Else
                        playersoundvolume = max((2.5 - ((Float crouch) * 0.6)), playersoundvolume)
                        local7 = playsound_strict(stepsfx((Int local5), $01, rand($00, $07)))
                        channelvolume(local7, ((1.0 - ((Float crouch) * 0.6)) * sfxvolume))
                    EndIf
                ElseIf (currstepsfx = $01) Then
                    local7 = playsound_strict(step2sfx(rand($00, $02)))
                    channelvolume(local7, ((1.0 - ((Float crouch) * 0.4)) * sfxvolume))
                ElseIf (currstepsfx = $02) Then
                    local7 = playsound_strict(step2sfx(rand($03, $05)))
                    channelvolume(local7, ((1.0 - ((Float crouch) * 0.4)) * sfxvolume))
                ElseIf (currstepsfx = $03) Then
                    If (1.0 = local0) Then
                        playersoundvolume = max(4.0, playersoundvolume)
                        local7 = playsound_strict(stepsfx($00, $00, rand($00, $07)))
                        channelvolume(local7, ((1.0 - ((Float crouch) * 0.6)) * sfxvolume))
                    Else
                        playersoundvolume = max((2.5 - ((Float crouch) * 0.6)), playersoundvolume)
                        local7 = playsound_strict(stepsfx($00, $01, rand($00, $07)))
                        channelvolume(local7, ((1.0 - ((Float crouch) * 0.6)) * sfxvolume))
                    EndIf
                EndIf
            EndIf
        EndIf
    ElseIf (keydown(key_sprint) <> 0) Then
        local0 = 2.5
    ElseIf (keydown(key_crouch) <> 0) Then
        local0 = 0.5
    EndIf
    If ((keyhit(key_crouch) And playable) <> 0) Then
        crouchchn = playsound_strict(crouchsfx)
        crouch = (crouch = $00)
    EndIf
    local8 = ((local1 * local0) / (1.0 + crouchstate))
    If (chs\Field1 <> 0) Then
        shake = 0.0
        currspeed = 0.0
        crouchstate = 0.0
        crouch = $00
        rotateentity(collider, wrapangle(entitypitch(camera, $00)), wrapangle(entityyaw(camera, $00)), 0.0, $00)
        local8 = (local8 * noclipspeed)
        If (keydown(key_down) <> 0) Then
            moveentity(collider, 0.0, 0.0, (local4\Field3[$00] * (- local8)))
        EndIf
        If (keydown(key_up) <> 0) Then
            moveentity(collider, 0.0, 0.0, (local4\Field3[$00] * local8))
        EndIf
        If (keydown(key_left) <> 0) Then
            moveentity(collider, (local4\Field3[$00] * (- local8)), 0.0, 0.0)
        EndIf
        If (keydown(key_right) <> 0) Then
            moveentity(collider, (local4\Field3[$00] * local8), 0.0, 0.0)
        EndIf
        resetentity(collider)
    Else
        local8 = (local8 / max(((injuries + 3.0) / 3.0), 1.0))
        If (0.5 < injuries) Then
            local8 = (min((sin((shake / 2.0)) + 1.2), 1.0) * local8)
        EndIf
        local5 = 0.0
        If (i_008\Field1 = $00) Then
            If ((keydown(key_down) And playable) <> 0) Then
                local5 = 1.0
                local3 = 180.0
                If (keydown(key_left) <> 0) Then
                    local3 = 135.0
                EndIf
                If (keydown(key_right) <> 0) Then
                    local3 = -135.0
                EndIf
            ElseIf ((keydown(key_up) And playable) <> 0) Then
                local5 = 1.0
                local3 = 0.0
                If (keydown(key_left) <> 0) Then
                    local3 = 45.0
                EndIf
                If (keydown(key_right) <> 0) Then
                    local3 = -45.0
                EndIf
            ElseIf (0.0 < forcemove) Then
                local5 = 1.0
                local3 = forceangle
            ElseIf (playable <> 0) Then
                If (keydown(key_left) <> 0) Then
                    local3 = 90.0
                    local5 = 1.0
                EndIf
                If (keydown(key_right) <> 0) Then
                    local3 = -90.0
                    local5 = 1.0
                EndIf
            EndIf
        Else
            local5 = 1.0
            local3 = forceangle
        EndIf
        local3 = wrapangle(((entityyaw(collider, $01) + local3) + 90.0))
        If ((Int local5) <> 0) Then
            currspeed = curvevalue(local8, currspeed, 20.0)
        Else
            currspeed = max(curvevalue(0.0, (currspeed - 0.1), 1.0), 0.0)
        EndIf
        If (unabletomove = $00) Then
            translateentity(collider, ((cos(local3) * currspeed) * local4\Field3[$00]), 0.0, ((sin(local3) * currspeed) * local4\Field3[$00]), $01)
        EndIf
        local9 = $00
        For local2 = $01 To countcollisions(collider) Step $01
            If ((entityy(collider, $00) - 0.25) > collisiony(collider, local2)) Then
                local9 = $01
            EndIf
        Next
        If (local9 = $01) Then
            If (-0.07 > dropspeed) Then
                If (currstepsfx = $00) Then
                    playsound_strict(stepsfx(getstepsound(collider), $00, rand($00, $07)))
                ElseIf (currstepsfx = $01) Then
                    playsound_strict(step2sfx(rand($00, $02)))
                ElseIf (currstepsfx = $02) Then
                    playsound_strict(step2sfx(rand($03, $05)))
                ElseIf (currstepsfx = $03) Then
                    playsound_strict(stepsfx($00, $00, rand($00, $07)))
                EndIf
                playersoundvolume = max(3.0, playersoundvolume)
            EndIf
            dropspeed = 0.0
        ElseIf (0.0 <> playerfallingpickdistance) Then
            local10 = linepick(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 0.0, (- playerfallingpickdistance), 0.0, 0.0)
            If (local10 <> 0) Then
                dropspeed = min(max((dropspeed - (local4\Field3[$00] * 0.006)), -2.0), 0.0)
            Else
                dropspeed = 0.0
            EndIf
        Else
            dropspeed = min(max((dropspeed - (local4\Field3[$00] * 0.006)), -2.0), 0.0)
        EndIf
        playerfallingpickdistance = 10.0
        If (((unabletomove = $00) And shouldentitiesfall) <> 0) Then
            translateentity(collider, 0.0, (local4\Field3[$00] * dropspeed), 0.0, $00)
        EndIf
    EndIf
    forcemove = 0.0
    If (((1.0 < injuries) And (i_1079\Field1 = $00)) <> 0) Then
        local8 = bloodloss
        blurtimer = max(max(((sin(((Float millisecs2()) / 100.0)) * bloodloss) * 30.0), ((bloodloss * 2.0) * (2.0 - crouchstate))), blurtimer)
        If (((i_427\Field0 = $01) And (25200.0 > i_427\Field1)) = $00) Then
            bloodloss = min((((min(injuries, 3.5) / 300.0) * local4\Field3[$00]) + bloodloss), 100.0)
        EndIf
    ElseIf (((1.0 < injuries) And (i_1079\Field1 = $01)) <> 0) Then
        local8 = i_1079\Field0
        blurtimer = max(max(((sin(((Float millisecs2()) / 100.0)) * i_1079\Field0) * 30.0), ((i_1079\Field0 * 2.0) * (2.0 - crouchstate))), blurtimer)
        If (((i_427\Field0 = $01) And (25200.0 > i_427\Field1)) = $00) Then
            i_1079\Field0 = min((((min(injuries, 3.5) / 300.0) * local4\Field3[$00]) + i_1079\Field0), 100.0)
        EndIf
        If (((60.0 >= local8) And (60.0 < bloodloss)) <> 0) Then
            msg = scplang_getphrase("ingame.bloodloss")
            msgtimer = 280.0
        EndIf
        If (((60.0 >= local8) And (60.0 < i_1079\Field0)) <> 0) Then
            msg = scplang_getphrase("ingame.bloodloss")
            msgtimer = 280.0
        EndIf
    EndIf
    update409()
    update008()
    If (((0.0 < bloodloss) And (0.0 <= vomittimer)) <> 0) Then
        If (min(injuries, 4.0) > rnd(200.0, 0.0)) Then
            local11 = createpivot($00)
            positionentity(local11, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
            turnentity(local11, 90.0, 0.0, 0.0, $00)
            entitypick(local11, 0.3)
            local12 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
            local12\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
            entityalpha(local12\Field0, 1.0)
            scalesprite(local12\Field0, local12\Field2, local12\Field2)
            local7 = playsound_strict(dripsfx(rand($00, $05)))
            channelvolume(local7, (rnd(0.0, 0.8) * sfxvolume))
            channelpitch(local7, rand($4E20, $7530))
            freeentity(local11)
        EndIf
        currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * bloodloss) * 0.2))
        If (60.0 < bloodloss) Then
            If (crouch = $00) Then
                crouchchn = playsound_strict(crouchsfx)
            EndIf
            crouch = $01
        EndIf
        If (100.0 <= bloodloss) Then
            kill($01, $00)
            heartbeatvolume = 0.0
        ElseIf (80.0 < bloodloss) Then
            heartbeatrate = max((150.0 - ((bloodloss - 80.0) * 5.0)), heartbeatrate)
            heartbeatvolume = max(heartbeatvolume, (((bloodloss - 80.0) * (1.0 / 80.0)) + 0.75))
        ElseIf (35.0 < bloodloss) Then
            heartbeatrate = max((70.0 + bloodloss), heartbeatrate)
            heartbeatvolume = max(heartbeatvolume, ((bloodloss - 35.0) / 60.0))
        EndIf
    EndIf
    If (0.0 < i_1079\Field0) Then
        If (min(injuries, 4.0) > rnd(200.0, 0.0)) Then
            local11 = createpivot($00)
            positionentity(local11, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
            turnentity(local11, 90.0, 0.0, 0.0, $00)
            entitypick(local11, 0.3)
            local12 = createdecal(rand($16, $17), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
            local12\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
            entityalpha(local12\Field0, 1.0)
            scalesprite(local12\Field0, local12\Field2, local12\Field2)
            local7 = playsound_strict(sizzsfx(rand($00, $01)))
            channelvolume(local7, (rnd(0.0, 0.8) * sfxvolume))
            channelpitch(local7, rand($4E20, $7530))
            freeentity(local11)
        EndIf
        currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * bloodloss) * 0.2))
        If (60.0 < i_1079\Field0) Then
            If (crouch = $00) Then
                crouchchn = playsound_strict(crouchsfx)
            EndIf
            crouch = $01
        EndIf
        If (100.0 <= i_1079\Field0) Then
            kill($01, $00)
            heartbeatvolume = 0.0
        ElseIf (80.0 < i_1079\Field0) Then
            heartbeatrate = max((150.0 - ((i_1079\Field0 - 80.0) * 5.0)), heartbeatrate)
            heartbeatvolume = max(heartbeatvolume, (((i_1079\Field0 - 80.0) * (1.0 / 80.0)) + 0.75))
        ElseIf (35.0 < i_1079\Field0) Then
            heartbeatrate = max((i_1079\Field0 + 70.0), heartbeatrate)
            heartbeatvolume = max(heartbeatvolume, ((i_1079\Field0 - 35.0) / 60.0))
        EndIf
    EndIf
    If (0.0 < healtimer) Then
        healtimer = (healtimer - (local4\Field3[$00] / 70.0))
        bloodloss = min(((local4\Field3[$00] * 0.005) + bloodloss), 100.0)
        injuries = max((injuries - ((local4\Field3[$00] / 70.0) / 30.0)), 0.0)
    EndIf
    If (playable <> 0) Then
        If (keyhit(key_blink) <> 0) Then
            blinktimer = 0.0
        EndIf
        If ((keydown(key_blink) And (-10.0 > blinktimer)) <> 0) Then
            blinktimer = -10.0
        EndIf
    EndIf
    If (0.0 < heartbeatvolume) Then
        If (0.0 >= heartbeattimer) Then
            local7 = playsound_strict(heartbeatsfx)
            channelvolume(local7, (heartbeatvolume * sfxvolume))
            heartbeattimer = ((60.0 / max(heartbeatrate, 1.0)) * 70.0)
        Else
            heartbeattimer = (heartbeattimer - local4\Field3[$00])
        EndIf
        heartbeatvolume = max((heartbeatvolume - (local4\Field3[$00] * 0.05)), 0.0)
    EndIf
    Return $00
End Function
