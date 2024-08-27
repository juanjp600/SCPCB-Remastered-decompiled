Function loadallsounds%()
    Local local0%
    For local0 = $00 To $02 Step $01
        opendoorsfx($00, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\DoorOpen" + (Str (local0 + $01))) + ".ogg")))
        closedoorsfx($00, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\DoorClose" + (Str (local0 + $01))) + ".ogg")))
        opendoorsfx($02, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\Door2Open" + (Str (local0 + $01))) + ".ogg")))
        closedoorsfx($02, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\Door2Close" + (Str (local0 + $01))) + ".ogg")))
        opendoorsfx($03, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\ElevatorOpen" + (Str (local0 + $01))) + ".ogg")))
        closedoorsfx($03, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\ElevatorClose" + (Str (local0 + $01))) + ".ogg")))
    Next
    For local0 = $00 To $01 Step $01
        opendoorsfx($01, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\BigDoorOpen" + (Str (local0 + $01))) + ".ogg")))
        closedoorsfx($01, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\BigDoorClose" + (Str (local0 + $01))) + ".ogg")))
    Next
    keycardsfx1 = loadsound_strict(scpmodding_processfilepath("SFX\Interact\KeyCardUse1.ogg"))
    keycardsfx2 = loadsound_strict(scpmodding_processfilepath("SFX\Interact\KeyCardUse2.ogg"))
    buttonsfx2 = loadsound_strict(scpmodding_processfilepath("SFX\Interact\Button2.ogg"))
    scannersfx1 = loadsound_strict(scpmodding_processfilepath("SFX\Interact\ScannerUse1.ogg"))
    scannersfx2 = loadsound_strict(scpmodding_processfilepath("SFX\Interact\ScannerUse2.ogg"))
    For local0 = $00 To $01 Step $01
        opendoorfastsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Door\DoorOpenFast" + (Str (local0 + $01))) + ".ogg")))
    Next
    cautionsfx = loadsound_strict(scpmodding_processfilepath("SFX\Room\LockroomSiren.ogg"))
    camerasfx = loadsound_strict(scpmodding_processfilepath("SFX\General\Camera.ogg"))
    stonedragsfx = loadsound_strict(scpmodding_processfilepath("SFX\SCP\173\StoneDrag.ogg"))
    gunshotsfx = loadsound_strict(scpmodding_processfilepath("SFX\General\Gunshot.ogg"))
    gunshot2sfx = loadsound_strict(scpmodding_processfilepath("SFX\General\Gunshot2.ogg"))
    gunshot3sfx = loadsound_strict(scpmodding_processfilepath("SFX\General\BulletMiss.ogg"))
    gunshot4sfx = loadsound_strict(scpmodding_processfilepath("SFX\General\Gunshot3.ogg"))
    bullethitsfx = loadsound_strict(scpmodding_processfilepath("SFX\General\BulletHit.ogg"))
    teslaidlesfx = loadsound_strict(scpmodding_processfilepath("SFX\Room\Tesla\Idle.ogg"))
    teslaactivatesfx = loadsound_strict(scpmodding_processfilepath("SFX\Room\Tesla\WindUp.ogg"))
    teslapowerupsfx = loadsound_strict(scpmodding_processfilepath("SFX\Room\Tesla\PowerUp.ogg"))
    magnetupsfx = loadsound_strict(scpmodding_processfilepath("SFX\Room\106Chamber\MagnetUp.ogg"))
    magnetdownsfx = loadsound_strict(scpmodding_processfilepath("SFX\Room\106Chamber\MagnetDown.ogg"))
    For local0 = $00 To $03 Step $01
        decaysfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\106\Decay" + (Str local0)) + ".ogg")))
    Next
    burstsfx = loadsound_strict(scpmodding_processfilepath("SFX\Room\TunnelBurst.ogg"))
    For local0 = $00 To $06 Step $01
        rustlesfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\372\Rustle" + (Str local0)) + ".ogg")))
    Next
    death914sfx = loadsound_strict(scpmodding_processfilepath("SFX\SCP\914\PlayerDeath.ogg"))
    use914sfx = loadsound_strict(scpmodding_processfilepath("SFX\SCP\914\PlayerUse.ogg"))
    For local0 = $00 To $05 Step $01
        dripsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Character\D9341\BloodDrip" + (Str local0)) + ".ogg")))
    Next
    leversfx = loadsound_strict(scpmodding_processfilepath("SFX\Interact\LeverFlip.ogg"))
    lightsfx = loadsound_strict(scpmodding_processfilepath("SFX\General\LightSwitch.ogg"))
    buttghostsfx = loadsound_strict(scpmodding_processfilepath("SFX\SCP\Joke\789J.ogg"))
    radiosfx($01, $00) = loadsound_strict(scpmodding_processfilepath("SFX\Radio\RadioAlarm.ogg"))
    radiosfx($01, $01) = loadsound_strict(scpmodding_processfilepath("SFX\Radio\RadioAlarm2.ogg"))
    For local0 = $00 To $08 Step $01
        radiosfx($02, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Radio\SCPRadio" + (Str local0)) + ".ogg")))
    Next
    radiosquelch = loadsound_strict(scpmodding_processfilepath("SFX\Radio\Squelch.ogg"))
    radiostatic = loadsound_strict(scpmodding_processfilepath("SFX\Radio\Static.ogg"))
    radiobuzz = loadsound_strict(scpmodding_processfilepath("SFX\Radio\Buzz.ogg"))
    elevatorbeepsfx = loadsound_strict(scpmodding_processfilepath("SFX\General\Elevator\Beep.ogg"))
    elevatormovesfx = loadsound_strict(scpmodding_processfilepath("SFX\General\Elevator\Moving.ogg"))
    For local0 = $00 To $05 Step $01
        picksfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Interact\PickItem" + (Str local0)) + ".ogg")))
    Next
    ambientsfxamount($00) = $19
    ambientsfxamount($01) = $18
    ambientsfxamount($02) = $18
    ambientsfxamount($03) = $0F
    ambientsfxamount($04) = $05
    ambientsfxamount($05) = $0D
    For local0 = $00 To $02 Step $01
        oldmansfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\106\Corrosion" + (Str (local0 + $01))) + ".ogg")))
    Next
    oldmansfx($03) = loadsound_strict(scpmodding_processfilepath("SFX\SCP\106\Laugh.ogg"))
    oldmansfx($04) = loadsound_strict(scpmodding_processfilepath("SFX\SCP\106\Breathing.ogg"))
    oldmansfx($05) = loadsound_strict(scpmodding_processfilepath("SFX\Room\PocketDimension\Enter.ogg"))
    For local0 = $00 To $02 Step $01
        oldmansfx(($06 + local0)) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\106\WallDecay" + (Str (local0 + $01))) + ".ogg")))
    Next
    oldmansfx($09) = loadsound_strict(scpmodding_processfilepath("SFX\SCP\106\Laugh2.ogg"))
    For local0 = $00 To $02 Step $01
        scp173sfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\173\Rattle" + (Str (local0 + $01))) + ".ogg")))
    Next
    For local0 = $00 To $0B Step $01
        horrorsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Horror\Horror" + (Str local0)) + ".ogg")))
    Next
    For local0 = $0E To $0F Step $01
        horrorsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Horror\Horror" + (Str local0)) + ".ogg")))
    Next
    For local0 = $07 To $09 Step $01
        introsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Bang" + (Str (local0 - $06))) + ".ogg")))
    Next
    For local0 = $0A To $0C Step $01
        introsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Light" + (Str (local0 - $09))) + ".ogg")))
    Next
    introsfx($0F) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\173Vent.ogg"))
    alarmsfx($00) = loadsound_strict(scpmodding_processfilepath("SFX\Alarm\Alarm.ogg"))
    alarmsfx($01) = loadsound_strict(scpmodding_processfilepath("SFX\Alarm\Alarm2.ogg"))
    alarmsfx($02) = loadsound_strict(scpmodding_processfilepath("SFX\Alarm\Alarm3.ogg"))
    alarmsfx($03) = loadsound_strict(scpmodding_processfilepath("SFX\Alarm\Alarm4.ogg"))
    alarmsfx($04) = loadsound_strict(scpmodding_processfilepath("SFX\Alarm\Alarm5.ogg"))
    alarmsfx($05) = loadsound_strict(scpmodding_processfilepath("SFX\Alarm\Alarm6.ogg"))
    heartbeatsfx = loadsound_strict(scpmodding_processfilepath("SFX\Character\D9341\Heartbeat.ogg"))
    For local0 = $00 To $04 Step $01
        breathsfx($00, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Character\D9341\breath" + (Str local0)) + ".ogg")))
        breathsfx($01, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Character\D9341\breath" + (Str local0)) + "gas.ogg")))
    Next
    For local0 = $00 To $02 Step $01
        necksnapsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\173\NeckSnap" + (Str (local0 + $01))) + ".ogg")))
    Next
    For local0 = $00 To $08 Step $01
        damagesfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Character\D9341\Damage" + (Str (local0 + $01))) + ".ogg")))
    Next
    For local0 = $00 To $02 Step $01
        coughsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Character\D9341\Cough" + (Str (local0 + $01))) + ".ogg")))
    Next
    machinesfx = loadsound_strict(scpmodding_processfilepath("SFX\SCP\914\Refining.ogg"))
    apachesfx = loadsound_strict(scpmodding_processfilepath("SFX\Character\Apache\Propeller.ogg"))
    For local0 = $00 To $07 Step $01
        stepsfx($00, $00, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Step\Step" + (Str (local0 + $01))) + ".ogg")))
        stepsfx($01, $00, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Step\StepMetal" + (Str (local0 + $01))) + ".ogg")))
        stepsfx($00, $01, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Step\Run" + (Str (local0 + $01))) + ".ogg")))
        stepsfx($01, $01, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Step\RunMetal" + (Str (local0 + $01))) + ".ogg")))
        If (local0 < $03) Then
            stepsfx($02, $00, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\Step" + (Str (local0 + $01))) + ".ogg")))
            stepsfx($03, $00, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\049\Step" + (Str (local0 + $01))) + ".ogg")))
        EndIf
        If (local0 < $04) Then
            stepsfx($04, $00, local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Step\SCP\StepSCP" + (Str (local0 + $01))) + ".ogg")))
        EndIf
    Next
    For local0 = $00 To $02 Step $01
        step2sfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Step\StepPD" + (Str (local0 + $01))) + ".ogg")))
        step2sfx((local0 + $03)) = loadsound_strict(scpmodding_processfilepath((("SFX\Step\StepForest" + (Str (local0 + $01))) + ".ogg")))
    Next
    For local0 = $00 To $01 Step $01
        nvguse(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Interact\NVGuse" + (Str local0)) + ".ogg")))
    Next
    ambient1123sfx = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1123\Ambient.ogg"))
    firesfx = loadsound_strict(scpmodding_processfilepath("SFX\SCP\457\FireLoop.ogg"))
    For local0 = $00 To $03 Step $01
        damagesfx1033ru(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\1033RU\Damage" + (Str local0)) + ".ogg")))
    Next
    deathsfx1033ru = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1033RU\SCPDeath.ogg"))
    For local0 = $00 To $01 Step $01
        sizzsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\1079\BubbleSizz" + (Str local0)) + ".ogg")))
    Next
    For local0 = $00 To $01 Step $01
        scientistradiosfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Character\Scientist\Radio" + (Str local0)) + ".ogg")))
    Next
    For local0 = $11 To $15 Step $01
        horrorsfx(local0) = loadsound_strict(scpmodding_processfilepath((("SFX\Horror\Horror" + (Str local0)) + ".ogg")))
    Next
    relaxedbreathsfx = loadsound_strict(scpmodding_processfilepath("SFX\Character\D9341\RelaxedBreathGas.ogg"))
    crouchsfx = loadsound_strict(scpmodding_processfilepath("SFX\Character\D9341\Crouch.ogg"))
    radiostatic895 = loadsound_strict(scpmodding_processfilepath("SFX\Radio\Static895.ogg"))
    vehiclesfx($00) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Vehicle\VehicleMove.ogg"))
    vehiclesfx($01) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Vehicle\VehicleIdle.ogg"))
    Return $00
End Function
